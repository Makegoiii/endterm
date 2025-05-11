package Chainresponse;

public class JuniorSupportHandler extends SupportHandler {
    public void handle(String issue) {
        if (issue.equals("refund_request") || issue.equals("billing_issue")) {
            System.out.println("[JuniorSupport] Handled " + issue);
        } else if (next != null) {
            next.handle(issue);
        } else {
            System.out.println("[JuniorSupport] Cannot handle — escalate manually");
        }
    }
}
