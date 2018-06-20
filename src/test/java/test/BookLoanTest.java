package test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import model.Book;
import model.Loan;
import model.Member;

@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:spring-mvc-config.xml"})

public class BookLoanTest {
    private static Member member1=null;
    private static Member member2=null;
    private static Member member3=null;
    private static Book book1=null;
    private static Book book2=null;
    private static Book book3=null;
    private static Book book4=null;
    private static Book book5=null;
    private static Book book6=null;
    private static Book book7=null;
    private static Book book8=null;
    private static Book book9=null;
    
    public void createData(){
    	//member构造
    	member1= new Member(001,"yangruijia",new ArrayList<Loan>());
    	member2= new Member(002,"shuqiqi",new ArrayList<Loan>());
    	member3= new Member(003,"zhouying",new ArrayList<Loan>());

    	//book构造
    	book1=new Book(1,"TS971.2/C-267","吃货辞典1",member1);
    	book2=new Book(2,"TS971.2/C-267","吃货辞典2",null);
    	book3=new Book(3,"TS971.2/C-267","吃货辞典3",null);
    	
    	book4=new Book(4,"I512.44/T-763.13","罪与罚1",member1);
    	book5=new Book(5,"I512.44/T-763.13","罪与罚2",null);
    	book6=new Book(6,"I512.44/T-763.13","罪与罚3",member2);

    	book7=new Book(7,"O412.1/L-853","量子引力之旅1",member1);
    	book8=new Book(8,"O412.1/L-853","量子引力之旅2",member3);
    	book9=new Book(9,"O412.1/L-853","量子引力之旅3",null);
    	
    	//设置当前日期
        LocalDateTime now=LocalDateTime.now();
    	//还书记录
    	Loan loan1 =new Loan(1,now.minusDays(50),now.minusDays(40),now.minusDays(30),book5,member1);
    	Loan loan2 =new Loan(1,now.minusDays(40),now.minusDays(30),now.minusDays(20),book3,member1);
    	Loan loan3 =new Loan(1,now.minusDays(45),now.minusDays(40),now.minusDays(30),book6,member2);
    	Loan loan4 =new Loan(1,now.minusDays(55),now.minusDays(47),now.minusDays(34),book4,member3);
//    	Loan loan5 =new Loan(1,now.minusDays(52),now.minusDays(40),now.minusDays(20),book5,member2);
//    	Loan loan6 =new Loan(1,now.minusDays(33),now.minusDays(29),now.minusDays(28),book8,member3);
    	
    	//未还记录
    	Loan loan7 =new Loan(1,now.minusDays(5),now.plusDays(25),null,book1,member1);
    	Loan loan8 =new Loan(1,now.minusDays(5),now.plusDays(25),null,book4,member1);
    	Loan loan9 =new Loan(1,now.minusDays(3),now.plusDays(27),null,book7,member1);
    	Loan loan10 =new Loan(1,now.minusDays(7),now.plusDays(23),null,book6,member2);
    	Loan loan11 =new Loan(1,now.minusDays(1),now.plusDays(29),null,book8,member3);
//    	Loan loan12 =new Loan(1,now.minusDays(9),now.minusDays(21),null,book5,member3);

    	//加入数据
    	member1.getLoans().add(loan1);
    	member1.getLoans().add(loan2);
    	member1.getLoans().add(loan7);
    	member1.getLoans().add(loan8);
    	member1.getLoans().add(loan9);

    	member2.getLoans().add(loan3);
    	member2.getLoans().add(loan10);
    	
    	
    	member3.getLoans().add(loan4);
    	member3.getLoans().add(loan11);

    }
    @Test
    public void loanBook(){
        createData();
        
        //杨蕤嘉借满三本，不能再借
        System.out.println("借阅人杨蕤嘉：" + member1);
        member1.getLoans().stream().forEach(loan -> {
        	System.out.println("杨蕤嘉借书记录：" + loan);
        });
        System.out.println("所借书籍："+book3);
        System.out.println("借书状态：" + member1.CanLoan(book3));
        
        System.out.println("");
        
        //舒琪琪不能重复借book6
        System.out.println("借阅人舒琪琪：" + member2);
        member2.getLoans().stream().forEach(loan -> {
        	System.out.println("舒琪琪借书记录：" + loan);
        });
        System.out.println("所借书籍："+book6);
        System.out.println("借书状态：" + member1.CanLoan(book6));
        
        System.out.println("");

        //周颖借book2
        System.out.println("借阅人周颖：" + member3);
        member3.getLoans().stream().forEach(loan -> {
        	System.out.println("周颖借书记录：" + loan);
        });
        System.out.println("所借书籍："+book2);
        System.out.println("借书状态：" + member3.CanLoan(book2));
        if(member3.CanLoan(book2)){
            Loan loan=member3.loan(book2);
            System.out.println("生成借书记录："+loan);
            System.out.println("所借图书状态："+book2);
        }
        
        System.out.println("");

        //周颖还book2
        System.out.println("借阅人周颖：" + member3);
        member3.getLoans().stream().forEach(loan -> {
        	System.out.println("周颖借书记录：" + loan);
        });
        System.out.println("要还书籍："+book2);
        member3.Return(book2);
        System.out.println("已还图书状态："+book2);
        System.out.println("");

    }
}
