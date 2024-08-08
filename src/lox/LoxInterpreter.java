package lox;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

public class LoxInterpreter {

    private static boolean has_error = false;

    public static void main(String args[]) throws IOException{
        if (args.length > 1)
            System.out.println("Usage: jlox [script]");
        else if (args.length == 1)
            runFile(args[0]);
        else
            runPrompt();
    }

    private static void runFile(String path) throws IOException{
        byte[] text = Files.readAllBytes(Paths.get(path));
        run(new String(text, Charset.defaultCharset()));

        if (has_error)
            System.exit(65);
    }

    private static void runPrompt() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println(">");
            String line = reader.readLine();
            if (line == null) break;
            run(line);
            has_error = false;
        }
    }

    private static void run(String source) {
        LoxLexer lex = new LoxLexer(source);
        List<Token> tokens = lex.tokenize();

        for (Token t : tokens)
            System.out.println(t);
    }

    static void error(int line, String msg) {
        report(line, "", msg);
    }

    private static void report(int line, String where, String msg) {
        System.err.println("[line " +line+"] Error " +where + ":" + msg);
        has_error = true;
    }
}
