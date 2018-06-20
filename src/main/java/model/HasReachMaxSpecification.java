package model;


public class HasReachMaxSpecification implements ISPecification<Member> {
   
	@Override
    public boolean isSatisfiedBy(Member member) {
        return member.getLoans().stream().filter(loan -> loan.hasNotBeenReturned()).count()<3;
    }
}
