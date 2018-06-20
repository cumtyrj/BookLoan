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
    	//member����
    	member1= new Member(001,"yangruijia",new ArrayList<Loan>());
    	member2= new Member(002,"shuqiqi",new ArrayList<Loan>());
    	member3= new Member(003,"zhouying",new ArrayList<Loan>());

    	//book����
    	book1=new Book(1,"TS971.2/C-267","�Ի��ǵ�1",member1);
    	book2=new Book(2,"TS971.2/C-267","�Ի��ǵ�2",null);
    	book3=new Book(3,"TS971.2/C-267","�Ի��ǵ�3",null);
    	
    	book4=new Book(4,"I512.44/T-763.13","���뷣1",member1);
    	book5=new Book(5,"I512.44/T-763.13","���뷣2",null);
    	book6=new Book(6,"I512.44/T-763.13","���뷣3",member2);

    	book7=new Book(7,"O412.1/L-853","��������֮��1",member1);
    	book8=new Book(8,"O412.1/L-853","��������֮��2",member3);
    	book9=new Book(9,"O412.1/L-853","��������֮��3",null);
    	
    	//���õ�ǰ����
        LocalDateTime now=LocalDateTime.now();
    	//�����¼
    	Loan loan1 =new Loan(1,now.minusDays(50),now.minusDays(40),now.minusDays(30),book5,member1);
    	Loan loan2 =new Loan(1,now.minusDays(40),now.minusDays(30),now.minusDays(20),book3,member1);
    	Loan loan3 =new Loan(1,now.minusDays(45),now.minusDays(40),now.minusDays(30),book6,member2);
    	Loan loan4 =new Loan(1,now.minusDays(55),now.minusDays(47),now.minusDays(34),book4,member3);
//    	Loan loan5 =new Loan(1,now.minusDays(52),now.minusDays(40),now.minusDays(20),book5,member2);
//    	Loan loan6 =new Loan(1,now.minusDays(33),now.minusDays(29),now.minusDays(28),book8,member3);
    	
    	//δ����¼
    	Loan loan7 =new Loan(1,now.minusDays(5),now.plusDays(25),null,book1,member1);
    	Loan loan8 =new Loan(1,now.minusDays(5),now.plusDays(25),null,book4,member1);
    	Loan loan9 =new Loan(1,now.minusDays(3),now.plusDays(27),null,book7,member1);
    	Loan loan10 =new Loan(1,now.minusDays(7),now.plusDays(23),null,book6,member2);
    	Loan loan11 =new Loan(1,now.minusDays(1),now.plusDays(29),null,book8,member3);
//    	Loan loan12 =new Loan(1,now.minusDays(9),now.minusDays(21),null,book5,member3);

    	//��������
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
        
        //��ި�ν��������������ٽ�
        System.out.println("��������ި�Σ�" + member1);
        member1.getLoans().stream().forEach(loan -> {
        	System.out.println("��ި�ν����¼��" + loan);
        });
        System.out.println("�����鼮��"+book3);
        System.out.println("����״̬��" + member1.CanLoan(book3));
        
        System.out.println("");
        
        //�����������ظ���book6
        System.out.println("��������������" + member2);
        member2.getLoans().stream().forEach(loan -> {
        	System.out.println("�����������¼��" + loan);
        });
        System.out.println("�����鼮��"+book6);
        System.out.println("����״̬��" + member1.CanLoan(book6));
        
        System.out.println("");

        //��ӱ��book2
        System.out.println("��������ӱ��" + member3);
        member3.getLoans().stream().forEach(loan -> {
        	System.out.println("��ӱ�����¼��" + loan);
        });
        System.out.println("�����鼮��"+book2);
        System.out.println("����״̬��" + member3.CanLoan(book2));
        if(member3.CanLoan(book2)){
            Loan loan=member3.loan(book2);
            System.out.println("���ɽ����¼��"+loan);
            System.out.println("����ͼ��״̬��"+book2);
        }
        
        System.out.println("");

        //��ӱ��book2
        System.out.println("��������ӱ��" + member3);
        member3.getLoans().stream().forEach(loan -> {
        	System.out.println("��ӱ�����¼��" + loan);
        });
        System.out.println("Ҫ���鼮��"+book2);
        member3.Return(book2);
        System.out.println("�ѻ�ͼ��״̬��"+book2);
        System.out.println("");

    }
}
