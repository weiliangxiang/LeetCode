package demo20180107;

import org.testng.annotations.Test;
public class ReTryTest {
	  @Test
      public void test1(){
          System.out.println(1/1);
      }
      @Test
      public void test2(){
          System.out.println(1/0);
      }
  }


