package lab3;

public class SimEngine {

	/* m-masa
    tl-wspolczynnik tlumienia
    k-wspolczynnik sprzystosci
    l0-dlugosc swobodna spreyny
    g-wspólczynnik grawitacji
    z-polozenie masy
    v-predkosc
    xl-polozenie punktu zawieszenia */

    private double m,k,b,l0,g;

    private Vector2D z,v,xl;

    public SimEngine(double m, double k, double tl, double l0, Vector2D z, Vector2D v, Vector2D xl, double g){  // konstruktor z parametrami

        this.m=m;
        this.k=k;
        this.b=tl;
        this.l0=l0;
        this.z=z;
        this.v=v;
        this.xl=xl;
        this.g=g;
    }

    public double getM()
    {return m;}
    public void setM(double m){
        this.m=m;
    }

    public double getK()
    {return k;}
    public void setK(double k){
        this.k=k;
    }

    public double getTl()
    {return b;}
    public void setTl(double b){
        this.b=b;
    }

    public double getL0()
    {return l0;}
    public void setL0(double l0){
        this.l0=l0;
    }

    public Vector2D getZ()
    {return z;}
    public void setZ(Vector2D z){
        this.z=z;
    }

    public Vector2D getV()
    {return v;}
    public void setV(Vector2D v){
        this.v=v;
    }

    public Vector2D getXl()
    {return xl;}
    public void setXl(Vector2D xl){
        this.xl=xl;
    }

    public double getG()
    {return g;}
    public void setG(double g){
        this.g=g;
    }


    public void Przebieg(double dt){


        Vector2D Wyp=new Vector2D();
        Vector2D Graw=new Vector2D(0,m*g); //sila grawitacji
        Vector2D Fsprezystosci=new Vector2D(); //sila sprezystosci
        Vector2D Ftlumienia=new Vector2D(); //sila tlumienia


        Fsprezystosci=xl.minus(z).normalizacja().mnozenie(k*(z.minus(xl)).dlugosc()-l0); //sila sprezystosci
        Ftlumienia=v.mnozenie(-b); // (przeciwny zwrot do ruchu dlatego -b)
        Wyp=Fsprezystosci.suma(Ftlumienia).suma(Graw);

        v=v.suma(Wyp.mnozenie(dt/m)); //Euler
        z=z.suma(v.mnozenie(dt));
    }

    public void Zerowanie(){
        v.x=0;
        v.y=0;

    }

}
