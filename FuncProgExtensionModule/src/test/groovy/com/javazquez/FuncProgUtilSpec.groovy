package com.javazquez

import spock.lang.Specification

class FuncProgUtilSpec extends Specification{

	def "test map"(){
		expect:
			[ 1 ,2 ,3 ,4].map{it*2} == 	[ 1 ,2 ,3 ,4].collect{ it*2 } 	
	}	
	def "test reduce "(){
		expect:
			[ 1 ,2 ,3].reduce('*') == 6
			[ 1 ,2 ,3,4].reduce('+') == 10
			[ '1' ,'2' ,'3','4'].reduce('+') == '1234'
			[ 1 ,2 ,3].reduce('-') == -4
			[ 2, 2 ,2].reduce('**') == 16
			[ 1 ,2 ,3].reduce({acc, val -> acc + val}) ==[ 1 ,2 ,3].inject { acc, val -> acc + val}
	}
	def "test invalid argument"(){
	 	when:
	 		[ 1 ,2 ,3,4].reduce('%')
		then:
			thrown(IllegalArgumentException)
	}
	def "test filter"(){
		expect:
			[1,2,3,4,5,6,7,8,9].filter { it % 2 ==0 } == [2,4,6,8]
			[1,2,3,4,5,6,7,8,9].filter { it > 2 } == [3,4,5,6,7,8,9]
			"Juan Vazquez".toList().filter { it ==~ /[aeiou]/} == ['u','a','a','u','e']
	}
}
