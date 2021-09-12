package edu.drexel.se320;

import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.lang.StringBuilder;
import java.lang.UnsupportedOperationException;

import net.bytebuddy.asm.Advice.This;

public class Client {

    private String lastResult;
    StringBuilder sb = null;
    ServerConnection conn = new ServerConnection() {
        public boolean connectTo(String address) throws IOException {
        	throw new UnsupportedOperationException();
        }
        public boolean requestFileContents(String filename) throws IOException {
        	throw new UnsupportedOperationException();
        }
        public String read() throws IOException {
        	throw new UnsupportedOperationException();
        }
        public boolean moreBytes() throws IOException {
        	throw new UnsupportedOperationException();
        }
        public void closeConnection() throws IOException {
        	throw new UnsupportedOperationException();
        }
    };


    public Client() {
        lastResult = ""; 
    }

    public Client(ServerConnection sc) {
        lastResult = "";
        this.conn = sc;
    }

    
    public String requestFile(String server, String file) {
        if (server == null)
            throw new IllegalArgumentException("Null server address");
        if (file == null)
            throw new IllegalArgumentException("Null file");

        sb = new StringBuilder();

        try {
            if (conn.connectTo(server)) {
                boolean validFile = conn.requestFileContents(file);
                if (validFile) {
                    while (conn.moreBytes()) {
                        String tmp = conn.read();
                        if (tmp != null) {
                            sb.append(tmp);
                        }
                    }
                    conn.closeConnection();
                }
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }

        String result = sb.toString();
        lastResult = result;
        return result;
    }
}

