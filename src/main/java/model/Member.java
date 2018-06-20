package model;

import java.util.ArrayList;
import java.util.List;



public class Member {
    private Integer id;

    private String name;

    private List<Loan> loans=new ArrayList<Loan>();

    public Member() {
    }

    public Member(Integer id, String name, List<Loan> loans) {
        this.id = id;
        this.name = name;
        this.loans = loans;
    }
    //findCurrentLoanFor方法:在用户的所有租书记录中找出指定书的租赁记录
    public Loan FindCurrentLoanFor(Book book)
    {
		return (model.Loan) getLoans().stream()
				.filter(loan -> book.getId().equals(getId()))
				.findAny()
				.orElse(null);
   
    }
    //return方法
    public final void Return(Book book)
    {
    	Loan loan = FindCurrentLoanFor(book);
    	if(loan !=null)
    	{
    		loan.markAsReturned();
    		book.setLoanTo(null);
    	}
    }
    
    //CanLoan方法
    public final boolean CanLoan(Book book)
    {
//    	return book.getLoanTo() == null;
        HasReachMaxSpecification hasReachMaxSpecification=new HasReachMaxSpecification();
        LoanOnlyOneSpecification loanOnlyOneSpecification=new LoanOnlyOneSpecification(book);

        return book.getLoanTo()==null && hasReachMaxSpecification.isSatisfiedBy(this)&& loanOnlyOneSpecification.isSatisfiedBy(this);

    }
    
    //Loan方法
    public final Loan loan(Book book)
    {
    	Loan loan =null;
    	if(CanLoan(book))
    	{
    		loan =LoanFactory.createLoan(book, this);
    		getLoans().add(loan);
    	}
    	return loan;
    }
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
