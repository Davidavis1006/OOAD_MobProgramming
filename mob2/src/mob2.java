import java.util.ArrayList;

class Rental
{
	Movie movie;
	int daysRented;
	double price;
	
	public Rental(Movie movie, int daysRented)
	{
    	this.movie = movie;
    	this.daysRented = daysRented;
    	price=movie.getprice(daysRented);
	}
	
	public double getPrice()
	{
    	return price;
	}
}

class Movie
{
	String name;
	double price;
	double point;
	
	public Movie(String name)
	{
    	this.name = name;
	}
	
	public double getprice(int day)
	{
    	return 0;
	}
	
	public double getpoint()
	{
    	return point;
	}
	
	public String getname()
	{
    	return name;
	}
}

class NewRelease extends Movie
{
    public NewRelease(String name)
    {
        super(name);
        point=2;
        price=3;
    }
    
    @Override
    public double getprice(int day)
    {
        return price*day;
    }
}

class Regular extends Movie
{
    public Regular(String name)
    {
        super(name);
        point=1;
        price=2;
    }
    
    public double getprice(int day)
    {
        if(day<=2)
        	return price;
        else
        	return price+1.5*(day-2);
    }
}

class Children extends Movie
{
    public Children(String name)
    {
        super(name);
        price=1.5;
        point=0.5;
    }
    
    public double getprice(int day)
    {
        if(day<=3) 
        	return price;
        else 
        	return price+1.5*(day-3);
    }
}

class customer
{
    String name;
    double cur_point;
    double total_cost;
    ArrayList<Rental> rentals = new ArrayList<Rental>();
    
    public customer(String name)
    {
        this.name=name;
    }
    
    public void statement()
    {
        for(Rental r:rentals)
        {
            System.out.println("movie name : "+r.movie.getname()+" price : "+r.getPrice()+" point : "+r.movie.getpoint());
        }
        System.out.println("customer name : "+name+" total cost : "+total_cost+" total point : "+cur_point);
    }
    
    public void addMovie(Rental r)
    {
        rentals.add(r);
        cur_point+=r.movie.getpoint();
        total_cost+=r.getPrice();
    }
}

public class mob2
{
    public static void main(String[] args)
    {
        customer a=new customer("倫倫");
        customer b=new customer("六花醬");
        customer c=new customer("K昂");
        customer d=new customer("史家瑩");
        Movie m1=new NewRelease("我的名字");
        Movie m2=new Regular("K-O");
        Movie m3=new Regular("涼宮春日的");
        Movie m4=new Children("GIVEN");
    
        a.addMovie(new Rental(m4, 8));
        a.addMovie(new Rental(m1, 7));
        b.addMovie(new Rental(m1, 8));
        b.addMovie(new Rental(m2, 7));
        b.addMovie(new Rental(m3, 8));
        c.addMovie(new Rental(m2, 7));
        d.addMovie(new Rental(m4, 8));
        a.statement();
        b.statement();
        c.statement();
        d.statement();

        //2 month later new -> regular
        m1=new Regular("我的名字");
    }
}