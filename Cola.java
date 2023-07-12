/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author Cano
 */
public class Cola {

    int Q[];
    int inicio;
    int fin;

    public Cola(int cant) {
        inicio = -1;
        fin = -1;
        Q = new int[cant];
    }

    public boolean vacia() {
        return (inicio == -1);
    }

    public int get() {
        return (Q[inicio]);
    }

    public void encolar(int ele) {
        if (llena()) {
            System.out.println("Error: Cola llena");
            System.exit(1);
        } else {
            if (vacia()) {
                inicio++;
                fin++;
                Q[inicio] = ele;
            } else {
                fin = (fin + 1) % Q.length;
                Q[fin] = ele;
            }
        }
    }

    public int descolar() {
        int x = Q[inicio];
        if (fin == inicio) {
            inicio = -1;
            fin = -1;
        } else {
            inicio = ((inicio + 1) % Q.length);
        }
        return (x);
    }

    public boolean llena() {
        return (inicio == (fin + 1) % Q.length);
    }

    public int cantidad() {
        if (fin >= inicio) {
            return (fin - inicio + 1);
        } else {
            return (Q.length - inicio + fin + 1);
        }
    }

    public int Cantidad2() {
        if (!vacia()) {
            int m = fin + 1 - inicio;
            if ((inicio >= fin) && (inicio != 0)) {
                m = Q.length + m;
            }
            return m;
        } else {
            return 0;
        }
    }

    /*public void InvertirPC(){
    Pila p= new Pila(Q.length);
    while(!vacia()){
        p.Push(descolar());
    }
    while (! p.vacia()){
        encolar(p.Pop());
    }
}*/
    public void Invertir() {
        Cola Q1 = new Cola(Q.length);
        int x = 1;
        Q1.encolar(descolar());
        while (!vacia()) {
            Q1.encolar(descolar());
            for (int i = 1; i <= x; i++) {
                Q1.encolar(Q1.descolar());
            }
            x++;
        }
        while (!Q1.vacia()) {
            encolar(Q1.descolar());
        }

    }

    public void InvertirR() {
        if (vacia()) {

        } else {
            int x = descolar();
            InvertirR();
            encolar(x);
        }
    }

    public void Intercambiar() {
        int x = descolar();
        for (int i = 1; i < Q.length - 1; i++) {
            encolar(descolar());
        }
        encolar(x);
    }

    public void Eli_Rep() {
        int i = 1;
        while (i <= Q.length) {
            int x = descolar();
            for (int j = 1; j <= Q.length; j++) {
                int y = descolar();
                if (x != y) {
                    encolar(y);
                } else {
                    j++;
                }
            }
            encolar(x);
            i++;
        }
    }

    /*public void Cam_Extre(Cola T, Cola R){
    int k=1;
    while (k<=Cantidad2()){
        int x= T.descolar();
        int y= R.descolar();
        
        for(int i=1;i<Cantidad2();i++){
            T.encolar(T.descolar());
        }
        int a=T.descolar();
        for(int j=1;j<Cantidad2();j++){
            R.encolar(R.descolar());
        }
        int b=T.descolar();
        
        T.encolar(y);
        T.encolar(b);
        R.encolar(x);
        R.encolar(a);
        
        for(int i=1;i<Cantidad2();i++){
            T.encolar(T.descolar());
        }
        for(int j=1;j<Cantidad2();j++){
            R.encolar(R.descolar());
        }
    }
    k++;
}
     */
    public void Num_Continuos() {
        Cola Q1 = new Cola(Cantidad2());
        int i = 1;
        while (i <= Cantidad2()) {
            int x = descolar();
            for (int j = 1; j <= Cantidad2(); j++) {
                int y = descolar();
                if (x != y) {
                    encolar(y);
                } else {
                    Q1.encolar(y);
                    j++;
                }
            }
            Q1.encolar(x);
            i++;
        }
        while (!Q1.vacia()) {
            encolar(Q1.descolar());
        }
    }

//public void InsertarColaPila(int Ele) {
//        if (vacia()) {
//            encolar(Ele);
//        } else {
//            if (Ele <= get()) {
//                Cola Aux = new Cola(Cantidad2() + 1);
//                while (!vacia()) {
//                    int x = descolar();
//                    Aux.encolar(x);
//                }
//                encolar(Ele);
//                while (!Aux.vacia()) {
//                    int x = Aux.descolar();
//                    encolar(x);
//                }
//            } else {
//                if (Ele > Q[fin]) {
//                    encolar(Ele);
//                }
//            }
//        }
//
//    }
    public void Cam_Mitades() {
        for (int i = 1; i <= Cantidad2() / 2; i++) {
            encolar(descolar());
        }
    }

    public void Inver_Mitades() {
        Cola Q1 = new Cola(Cantidad2());
        int i = 1;
        while (i <= Cantidad2() / 2) {
            Q1.encolar(descolar());
        }
        i++;
        Q1.InvertirR();
        while (!Q1.vacia()) {
            encolar(Q1.descolar());
        }
        for (int j = 1; j <= Cantidad2() / 2; j++) {
            encolar(descolar());
        }
    }

    public void Inver_Mitad() {
        Cola Q1 = new Cola(Cantidad2());
        for (int i = 1; i <= (Cantidad2() / 2) + 1; i++) {
            Q1.encolar(descolar());
        }
        Q1.InvertirR();
        while (!Q1.vacia()) {
            encolar(Q1.descolar());
        }
        for (int j = 1; j <= Cantidad2() / 2; j++) {
            encolar(descolar());
        }
    }

    public void Inv_Pareja() {
        for (int i = 1; i <= Cantidad2() / 2; i++) {
            int x = descolar();
            int y = descolar();
            encolar(y);
            encolar(x);
        }
        if ((Cantidad2() % 2) != 0) {
            int z = descolar();
            encolar(z);
        }
    }

    @Override
    public String toString() {
        String s = "Q = ";
        for (int i = 1; i <= cantidad(); i++) {
            int x = descolar();
            s = s + "[" + x + "]" + " ";
            encolar(x);
        }
        return s;
    }

    public static void main(String[] args) {
        Cola q = new Cola(5);
        q.encolar(1);
        q.encolar(2);
        q.encolar(3);
        q.encolar(4);
        q.encolar(5);
        //q.descolar();
        //q.encolar(4);
        //q.encolar(2);
        //q.encolar(11);

        System.out.println(q);

        //q.InvertirPC();
        //q.Invertir();
        //q.InvertirR();
        //q.Intercambiar();
        //q.Eli_Rep();
        //System.out.println(q);
        Cola r = new Cola(7);
        r.encolar(1);
        r.encolar(2);
        r.encolar(3);
        r.encolar(4);
        r.encolar(5);
        r.encolar(6);
        r.encolar(7);
//     r.Num_Continuos();
//     r.Cam_Mitades();
//     r.Inver_Mitades();
//     r.Inver_Mitad();
        r.Inv_Pareja();
        System.out.println(r);

//      Cola Q= new Cola(5);
//      Q.Cam_Extre(q, r);
//        System.out.println(Q);
//     Cola s= new Cola(6);
//     s.InsertarColaPila(1);
//     s.InsertarColaPila(2);
//     s.InsertarColaPila(3);
//     s.InsertarColaPila(4);
//     s.InsertarColaPila(5);
//     s.descolar();
//     s.InsertarColaPila(7);
//     //q.encolar(2);
//     //q.encolar(11);
//     
//        System.out.println(s);
    }
}
