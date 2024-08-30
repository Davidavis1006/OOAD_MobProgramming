import java.util.*;

interface GuineaPig
{
	void noise();
	void eat(String food);
	void pupu();
}

class Car
{
	//int speed;
	int accelerate;
	void a_run(){};
	void reset(){};
}

class PoliceCar extends GuineaPigCarCar
{
	public PoliceCar(String name)
	{
		super(name);
		speed=14;
	}
	
	//public int speed=14;
	void a_run()
	{
		speed+=5;
	}
	
	void reset()
	{
		speed=14;
	}
}

class Ambulance extends GuineaPigCarCar
{
	public Ambulance()
	{
		speed=11;
	}
	
	public Ambulance(String name)
	{
		super(name);
		speed=11;
	}
	
	//public int speed=11;
	void a_run()
	{
		speed+=2;
	}
	
	void reset()
	{
		speed=11;
	}
}

class TrashTruck extends GuineaPigCarCar
{
	public TrashTruck(String name)
	{
		super(name);
		speed=8;
	}
	
	//public int speed=8;
	
	void a_run()
	{
		speed+=4;
	}
	
	void reset()
	{
		speed=8;
	}
}

class GuineaPigCarCar extends Car implements GuineaPig
{
	String name;
	ArrayList<String> food_list;
	int dis=0;
	public int speed;
	
	public GuineaPigCarCar() {}
	
	public GuineaPigCarCar(String name)
	{
		this.name=name;
		food_list=new ArrayList<>();
	}
	
	public void noise()
	{
		System.out.println("PUI PUI");
	}
	
	public void eat(String food)
	{
		food_list.add(food);
		//if (food_list.size()>5)
			//pupu();
	}
	
	public void pupu()
	{
		for (String s: food_list)
			System.out.println(name+" eat "+s);
		food_list.clear();
	}
}

public class mob1
{
	public static void main(String[] args)
	{
		GuineaPigCarCar si=new PoliceCar("Shiromo");
		GuineaPigCarCar a=new Ambulance("Abbey");
		GuineaPigCarCar t=new TrashTruck("Teddy");
		ArrayList<GuineaPigCarCar> g_list=new ArrayList<>();
        
		g_list.add(si);
		g_list.add(a);
		g_list.add(t);
		boolean finish=false;
		int time=0;
		
		while(true)
		{
			time++;
			for (int i=0; i<g_list.size(); i++)
			{
				GuineaPigCarCar mouse=g_list.get(i);
				System.out.println(mouse.name+" speed "+mouse.speed);
				mouse.dis+=mouse.speed;
				System.out.println(mouse.name+" dist "+mouse.dis);
				if (mouse.dis>=4000)
				{
					finish=true;
					break;
				}
			}
			
			if (finish) break;
				
			if (time%10==0)
			{
				GuineaPigCarCar first=g_list.get(0),last=g_list.get(0);
				for (GuineaPigCarCar c:g_list)
				{
					if (first.dis<c.dis)
					{
						first=c;
					}
					if (last.dis>c.dis)
					{
						last=c;
					}
				}
				
				first.eat("vegetable");
				last.eat("red");
				last.a_run();
				
				if (first.food_list.size()>5)
				{
					first.pupu();
					first.reset();
				}
				if (last.food_list.size()>5)
				{
					last.pupu();
					last.reset();
				}
			}
		}
		
		GuineaPigCarCar f=g_list.get(0);
		for (GuineaPigCarCar mouse: g_list)
		{
			if (f.dis<mouse.dis)
			{
				f=mouse;
			}
		}
		
		System.out.println(f.name + "champion");
		
		for (GuineaPigCarCar mouse: g_list)
		{
			if (f!=mouse)
			{
				System.out.println(mouse.name + "dist "+mouse.dis);
			}
		}     
	}
}