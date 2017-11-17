/**
 * A class to model a simple email client. The client is run by a
 * particular user, and sends and retrieves mail via a particular server.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MailClient
{
    // The server used for sending and receiving.
    private MailServer server;
    // The user running this client.
    private String user;
    // 
    private MailItem ultimoEmail;

    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;     
    }

    /**
     * Return the next mail item (if any) for this user.(Funcionalidad 04 - Dídac)
     */
    public MailItem getNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null){
            System.out.println("No new mail.");
        }
        else if((item.getMessage().indexOf("viagra")!=-1)||(item.getMessage().indexOf("regalo")!=-1)){
            item = null;
        }
        ultimoEmail = item;
        return item;
    }

    /**
     * Print the next mail item (if any) for this user to the text 
     * terminal.
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            System.out.println("No new mail.");
        }
        else {
            ultimoEmail = item;
            item.print();
        }
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to,String subject, String message)
    {
        MailItem item = new MailItem(user, to, subject, message);
        server.post(item);
    }

    /**
     * Funcionalidad 06 - Cristian
     */
    public void sendMailItemEncrypted(String to, String subject, String message){
        String cadena = message;
        cadena = cadena.replace('a', '$');
        cadena = cadena.replace('á', ')');
        cadena = cadena.replace('e', '&');
        cadena = cadena.replace('é', '_');
        cadena = cadena.replace('i', '#');
        cadena = cadena.replace('í', '@');
        cadena = cadena.replace('o', '+');
        cadena = cadena.replace('ó', '%');
        cadena = cadena.replace('u', '*');
        cadena = cadena.replace('ú', '!');
        cadena = "?=? " + cadena;

        MailItem item = new MailItem(user, to, subject, cadena);
        server.post(item);
    }

    /**
     * Funcionalidad 01 (Lorena)
     */
    public void totalMessage()
    {
        System.out.println("Tiene estos mensajes: " + server.howManyMailItems(user));
    }

    /**
     * Método añadido que permite imprimir por pantalla el último mensaje
     * tantas veces como se desee (Funcionalidad 02 - Aitor Martínez)
     */
    public void imprimirUltimoMensaje()
    {
        if(ultimoEmail == null) {
            System.out.println("Error");
        }
        else{ 
            ultimoEmail.print();  
        }
    }

    /**
     * Método que cuando se invoque permita descargar del servidor el siguiente mensaje del usuario
     * y responda automáticamente al emisor con una frase indicando que hemos recibido su correo y
     * dándole las gracias. Si no hay ningún mensaje para el usuario el método no hace nada 
     * e informa de la situación por pantalla.(Funcionalidad 03 - Diego)
     */
    public void getDownload()
    {
        MailItem item = server.getNextMailItem(this.user);
        if((item.getMessage().indexOf("viagra")!=-1)||(item.getMessage().indexOf("regalo")!=-1)){
            System.out.println("El mensaje es spam");
        }
        else if (item == null)
        {
            System.out.println("No hay ningun mensaje");
        }
        else
        {
            String gracias = "He recibido tu mensaje, gracias\n" + item.getMessage();
            String asuntoOriginal = "Re: " + item.getSubject();
            sendMailItem(item.getFrom(), asuntoOriginal, gracias);
            server.post(item);
            ultimoEmail = item;
            item.print();
        }
    }

}
