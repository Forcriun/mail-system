/**
 * A class to model a simple mail item. The item has sender and recipient
 * addresses and a message string.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MailItem
{
    // The sender of the item.
    private String from;
    // The intended recipient.
    private String to;
    // The subject of the message.
    private String subject;
    // The text of the message.
    private String message;
    //
    private boolean spam;

    /**
     * Create a mail item from sender to the given recipient,
     * containing the given message.
     * @param from The sender of this item.
     * @param to The intended recipient of this item.
     * @param message The text of the message to be sent.
     */
    public MailItem(String from, String to, String subject, String message)
    {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
        this.spam = false;
    }

    /**
     * @return The sender of this message.
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * @return The intended recipient of this message.
     */
    public String getTo()
    {
        return to;
    }

    /**
     * @return The text of the message.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Print this mail message to the text terminal. If the message is encrypted,
     * it decrypts it.
     */
    public void print()
    {
        detectSpam();
        if(spam == false){
            System.out.println("From: " + from);
            System.out.println("To: " + to);
            System.out.println("Subject: " + subject);
            String cadena = message.substring(0,3);
            if (cadena.equals("?=?")){
                message = message.replace('$', 'a');
                message = message.replace(':', 'á');
                message = message.replace('&', 'e');
                message = message.replace('_', 'é');
                message = message.replace('#', 'i');
                message = message.replace('@', 'í');
                message = message.replace('+', 'o');
                message = message.replace('%', 'ó');
                message = message.replace('*', 'u');
                message = message.replace('!', 'ú');

                System.out.println("Message: " + message);
            }
            else{
                System.out.println("Message: " + message);
            }
        }
        else{
            System.out.println("El mensaje es spam");
        }
    }

    public void detectSpam()
    {
        if((message.indexOf("regalo")!=-1)||(message.indexOf("viagra")!=-1)){
            spam = true;
        }
    }
}
