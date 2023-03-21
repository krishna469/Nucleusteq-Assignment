public class KKEmp{

    public int id;
    public String name;
    public int age;
    public String add;


    KKEmp(int id,String name,int  age,String add){
        this.id=id;
        this.name=name;
        this.age=age;
        this.add=add;

    }

    public String  toString(){

        return "id :"+id+"\nname :"+name+"\nage :"+age+"\nAddress :"+add+"------------------------------";
    }
}