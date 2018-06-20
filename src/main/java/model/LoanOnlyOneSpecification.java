package model;

public class LoanOnlyOneSpecification implements ISPecification<Member> {
	private Book wantBook;
	
	public LoanOnlyOneSpecification(Book wantBook){
		this.wantBook=wantBook;
	}
	@Override
	public boolean isSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		return member.getLoans().stream()
				.filter(loan -> loan.hasNotBeenReturned() && wantBook.getISBN().equals(loan.getBook().getISBN())).count()==0;

	}

}
