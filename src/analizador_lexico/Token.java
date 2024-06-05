package analizador_lexico;

public class Token {

    public String tipo;
    public String valor;
    public boolean validacion; 

    public Token(String type, String value, boolean validacion) {
        this.tipo = type;
        this.valor = value;
        this.validacion = validacion;
    }

    @Override
    public String toString() {
        return "Token{"
                + "Tipo='" + tipo + '\''
                + ", Valor='" + valor + '\''
                + ", Validacion='" + validacion + '\''
                + '}';
    }
}
