package analizador_lexico;

public class Token {

    public static String tipo;
    public static String valor;

    public Token(String type, String value) {
        this.tipo = type;
        this.valor = value;
    }

    @Override
    public String toString() {
        return "Token{"
                + "Tipo='" + tipo + '\''
                + ", Valor='" + valor + '\''
                + '}';
    }
}
