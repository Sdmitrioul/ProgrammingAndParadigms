package knf.makeKNF;

import knf.Expression;

import java.util.Map;

public class KNFform implements Form {
    private Expression expression;
    private String knfForm;
    private boolean[][] tableTrue;
    private Map<Integer, Character> variables;

    public KNFform(Expression expression, Map<Integer, Character> variables) {
        this.expression = expression;
        this.variables = variables;
        int columns = variables.size();
        TableTrue tableTry = new TableTrue(expression, columns);
        tableTrue = tableTry.getTableTrue();
        int raws = (int) Math.pow( 2, columns);
        writeKNF(raws);
    }

    @Override
    public String getForm() {
        return knfForm;
    }

    private void writeKNF(int raws) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < raws; i++) {
            if (!tableTrue[i][10]) {
                sb.append("(");
                for (Map.Entry<Integer, Character> entry : variables.entrySet()) {
                    if (!tableTrue[i][entry.getKey()]) {
                        sb.append(" ").append(entry.getValue()).append(" ").append('|');
                    } else {
                        sb.append(" ").append('~').append(entry.getValue()).append(" ").append('|');
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(") & ");
            }
        }
        sb.deleteCharAt(sb.length() - 2);
        knfForm = sb.toString();
    }
}
