package sistema.calificacion;

public class SistemaDeCalificacion {

    public static String calcularEquivalencia(double notaFinal) {
        if (notaFinal >= 9.00 && notaFinal <= 10.00) {
            return "Excelente";
        } else if (notaFinal >= 8.00 && notaFinal < 9.00) {
            return "Muy Bueno";
        } else if (notaFinal >= 7.00 && notaFinal < 8.00) {
            return "Bueno";
        } else if (notaFinal >= 6.50 && notaFinal < 7.00) {
            return "Satisfactorio";
        } else if (notaFinal >= 6.00 && notaFinal < 6.50) {
            return "Aceptable";
        } else {
            return "Deficiente";
        }
    }

    public static double calcularNotaFinal(double nota1, double nota2, double nota3, double notaPractica) {
        if (nota3 != -1) {
            if (nota3 > nota1 && nota1 < nota2) {
                nota1 = nota3;
            } else if (nota3 > nota2 && nota2 <= nota1) {
                nota2 = nota3;
            }
        }
        return ((nota1 + nota2) / 2) * 0.75 + (notaPractica * 0.25);
    }

    public static void main(String[] args) {
        double[][] casosDePrueba = {
            {9.00, 9.00, -1, 9.00},
            {8.00, 8.00, -1, 8.00},
            {7.00, 7.00, -1, 7.00},
            {6.50, 6.50, -1, 6.50},
            {6.00, 6.00, -1, 6.00},
            {5.99, 5.99, -1, 5.99},
            {10.00, 0.00, 10.00, 10.00},
            {8.99, 7.99, 9.00, 8.99},
            {7.01, 6.49, 7.00, 7.00},
            {6.51, 6.00, 6.50, 6.50},
            {6.00, 5.99, 6.00, 6.00},
            {0.00, 0.00, 0.00, 0.00}
        };

        String[] resultadosEsperados = {
            "Excelente",
            "Muy Bueno",
            "Bueno",
            "Satisfactorio",
            "Aceptable",
            "Deficiente",
            "Excelente",
            "Muy Bueno",
            "Bueno",
            "Satisfactorio",
            "Aceptable",
            "Deficiente"
        };

        for (int i = 0; i < casosDePrueba.length; i++) {
            double nota1 = casosDePrueba[i][0];
            double nota2 = casosDePrueba[i][1];
            double nota3 = casosDePrueba[i][2];
            double notaPractica = casosDePrueba[i][3];

            if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10 || (nota3 != -1 && (nota3 < 0 || nota3 > 10)) || notaPractica < 0 || notaPractica > 10) {
                System.out.println("Caso " + (i + 1) + ": Error (fuera de rango)");
                continue;
            }

            double notaFinal = calcularNotaFinal(nota1, nota2, nota3, notaPractica);
            String equivalenciaCalculada = calcularEquivalencia(notaFinal);
            String equivalenciaEsperada = resultadosEsperados[i];

            System.out.printf("Caso %d: Nota Final Calculada = %.2f (Esperado: %s)%n", (i + 1), notaFinal, equivalenciaEsperada);
        }
    }
}
