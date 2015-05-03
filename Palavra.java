package servidor;

public class Palavra {
    
    public String login;
    public String frase;
    
    public Palavra (String nome, String a)
    {
        login = nome;
        frase = a;
    }

    public void printLogin()
    {
        System.out.println(frase);
    }
}
