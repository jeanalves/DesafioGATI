package desafiogati;

public class UtilMensagem {
    
    private String mensagemString;
    private int mensagemInt;
    private boolean valido;
    private Campo campo;
    
    public String getMensagemString() {
        return mensagemString;
    }

    public void setMensagemString(String mensagem){
        this.mensagemString = mensagem;
    }
    
    public int getMensagemInt() {
        return mensagemInt;
    }

    public void setMensagemInt(int mensagemInt) {
        this.mensagemInt = mensagemInt;
    }
    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean validou) {
        this.valido = validou;
    }
    
    public Campo getCampo(){
        return campo;
    }
    
    public void setCampo(Campo campo){
        this.campo = campo;
    }
    
    public enum Campo{
        ID, NOME, EMAIL, TELEFONE, NUMERO, BAIRRO, CEP, ATIVO
    }
    
}
