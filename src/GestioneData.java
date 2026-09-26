import java.util.Scanner;

public class GestioneData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int anno = 0;
        int mese = 0;
        int giorno = 0;
        int tentativi; // Variabile che useremo per contare i tentativi

        // Array con i giorni per ciascun mese
        int[] giorniMesi = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // ================= 1. ACQUISIZIONE ANNO =================
        boolean annoValido = false;
        tentativi = 0; // Inizializziamo a 0 prima del ciclo

        do {
            tentativi++;
            System.out.print("Inserisci l'anno (0 - 2026) [Tentativo "
                    + tentativi + "/3]: ");
            anno = scanner.nextInt();

            if (anno >= 0 && anno <= 2026) {
                annoValido = true;
            } else {
                System.out.println("Anno errato! Deve essere compreso tra 0 e 2026.");
            }

        } while (!annoValido && tentativi < 3);

        // Se dopo 3 tentativi l'anno è ancora errato, blocchiamo il programma
        if (!annoValido) {
            System.out.println("Tentativi esauriti per l'anno. Programma terminato.");
            return;

        }

        // Controllo anno bisestile
        if ((anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0)) {
            giorniMesi[1] = 29; // Modifichiamo febbraio nell'array
        }

        // ================= 2. ACQUISIZIONE MESE =================
        boolean meseValido = false;
        tentativi = 0; // Resettiamo i tentativi per il nuovo inserimento

        do {
            tentativi++;
            System.out.print("Inserisci il mese (1 - 12) [Tentativo " + tentativi + "/3]: ");
            mese = scanner.nextInt();

            if (mese >= 1 && mese <= 12) {
                meseValido = true;
            } else {
                System.out.println("Mese errato! Deve essere compreso tra 1 e 12.");
            }

        } while (!meseValido && tentativi < 3);

        if (!meseValido) {
            System.out.println("Tentativi esauriti per il mese. Programma terminato.");
            return;
        }

        // ================= 3. ACQUISIZIONE GIORNO =================
        int maxGiorni = giorniMesi[mese - 1];
        boolean giornoValido = false;
        tentativi = 0; // Resettiamo di nuovo i tentativi

        do {
            tentativi++;
            System.out.print("Inserisci il giorno (1 - " + maxGiorni + ") [Tentativo " + tentativi + "/3]: ");
            giorno = scanner.nextInt();

            if (giorno >= 1 && giorno <= maxGiorni) {
                giornoValido = true;
            } else {
                System.out.println("Giorno errato per il mese inserito!");
            }

        } while (!giornoValido && tentativi < 3);

        if (!giornoValido) {
            System.out.println("Tentativi esauriti per il giorno. Programma terminato.");
            return;
        }

        // ================= ESITO FINALE =================
        System.out.println("\nData acquisita con successo: " + giorno + "/" + mese + "/" + anno);

        scanner.close();
    }
}