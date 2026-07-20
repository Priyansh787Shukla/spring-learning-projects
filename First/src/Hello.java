class A implements Runnable
{
    public void run()
    {
        for(int i = 0; i<5; i++)
        {
            System.out.println("Hi");
            try
            {
                Thread.sleep(10);
            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted");
            }
        }
    }
}
class B implements Runnable
{
    public void run()
    {
        for(int i = 0; i<5; i++)
        {
            System.out.println("Hello");
            try
            {
                Thread.sleep(10);
            }
            catch(InterruptedException e)
            {
                System.out.println("Interrupted");
            }
        }
    }
}
class Hello
{
    public static void main(String[] args)
    {
        Runnable a = new A();
        Runnable b = new B();
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
    }
}