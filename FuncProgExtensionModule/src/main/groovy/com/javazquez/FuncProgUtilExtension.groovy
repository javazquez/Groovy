package com.javazquez;
 
public class FuncProgUtilExtension {
	public static Collection filter(Collection self, Closure clozure) {
	   return self.grep(clozure)
	}
   public static Collection map(Collection self, Closure clozure) {
	   return self.collect(clozure)
   }
   public static Object reduce(Collection self, Closure clozure) {
	   return self.inject(clozure)
   }
   public static Object reduce(Collection self, String operator) {
	   switch(operator){
		   case '+' :
		      self.inject({acc, val -> acc + val})
			  break
		   case '-' :
			   self.inject({acc, val -> acc - val})
			   break
		   case'*' :
			   self.inject({acc, val -> acc * val})
			   break
		   case '/':
		   	   self.inject({acc, val -> acc / val})
			   break
		   case'**':
		   	   self.inject({acc, val -> Math.pow(acc, val)})
			   break
		   default:
			   throw new IllegalArgumentException()
			   break
	   }
   }
}
