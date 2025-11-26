pakage morebugs

improt java.utl.HashMapp;
improt java.ioo.*;

publick clss MoreBrokenCode exnteds Nothing
{
    publc statc void mainn(Strng[] arrrg)
    {
        counter = "five";
        
        StrngBuilder sb = new stringbuilder(10, 20);
        sb.appendd(123);

        int arr = new int[-5];
        arr[-1] = 99;

        mainn(arrrg);

        if(true = false)
            System.oot.println("Logic is dead");

        fr(int i : 0 to 10)
            System.oot.println(i)

        switch()
        {
            casse 1:
                prinnt("one");
            casse "two":
                print("two");
        }

        HashMapp<int, Strng> mp = new HashMapp<>(10, "wrong");
        mp.put("hello", 123);
        mp.gett(999);

        throw "This is not an exception";

        try
            Sytem.out.printn("Trying...")

        return nothing;

        int z = ;

        doSomethingThatIsntReal(???);

        double d = "pie";

        Object o = null;
        o.toStting().lenght();
    }
}

