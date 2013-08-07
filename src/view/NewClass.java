/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class NewClass {

    public static void main(String args[]) {
        int[] n = new int[] {
            1,2,3,4,5,6,7,8,9
        };
        //int[] n = new int[9];
        String s;
        
        /*for (int i = 0; i < 9; i++) {
            s = JOptionPane.showInputDialog("Digite um numero:");
            n[i] = Integer.parseInt(s);
        }*/
        
        for (int i = 0; i < 9; i++) {
            int p = 0;
            for (int j = 1; j < n[i]; j++) {
                if (n[i] % j == 0) {
                    p++;
                }
                if (p == 2) {
                    System.out.println(n[i]);
                    System.out.println(i);
                }
            }
        }
    }
}
