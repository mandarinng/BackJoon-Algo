import java.util.Scanner;
import java.util.Stack;
 
public class Main {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
 
            String calculate = sc.next();// 계산식
 
            // 연산자를 저장할 스택 선언 : plus
            Stack<Character> operator = new Stack<>();
            // 후위연산식 담을 스트링빌더(append함수로 문자열 받아서 더해주려고 사용함) : postfix
            StringBuilder postfix = new StringBuilder();
            // 중간중간 계산한 식(숫자)을 넣을 스택 선언 : stack
            Stack<Integer> stack = new Stack<>();
           
            // 중위 표기식 -> 후위 표기식
            for (int i = 0; i < calculate.length(); i++) {
                // calculate에서 입력된 것이 피연산자인지 연산자인지 판별하기 위해 char형 변수 만듦
                char c = calculate.charAt(i);
                 
                // 연산자가 입력됐을 때 스택에 넣기 -'('도 넣기. ')'는 x
                // 스택 안에서 우선순위 고려하기 1순위:*/ 2:-+ 3:(
                // 우선순위 높아야 스택에 쌓기 가능. 순위가 같거나 낮으면 스택의 peek값 pop해서 연산 수행
                switch (c) {
                case '*':
                case '/':
                    //연산자 스택이 비지 않았을 때
                    if (!operator.isEmpty()) {
                        char top = operator.peek();
                        //peek의 연산 순위가 나랑 같거나 높아서 찍어누를 수 없을 때
                        if (operator.peek() == '/' || operator.peek() == '*') {
                            //나보다 연산순위가 낮은거나 같은게 나올떄까지 나올떄까지 pop한 뒤에 후위연산식에 넣어줌
                            while (!operator.isEmpty()&&!( operator.peek() == '('||operator.peek() == '+' || operator.peek() == '-')) {
                                postfix.append(operator.pop());
                            }
                            operator.push(c);
                        }
                        //peek의 연산 순위가 나보다 낮을 때 그냥 연산자 스택에 push
                        else if (operator.peek() == '+' || operator.peek() == '-' || operator.peek() == '(') {
                            operator.push(c);
                        } 
                    } 
                    //연산자 스택이 비었을 때는 그냥 연산자 스택에 넣어주기
                    else {
                        operator.push(c);
                    }break;
     
                case '+':
                case '-': //+ 와 동일
                    //연산자 스택이 비지 않았을 때
                    if (!operator.isEmpty()) {
                        char top = operator.peek();
                        //peek의 연산 순위가 나랑 같거나 높아서 찍어누를 수 없을 때
                        if (operator.peek() == '/' || operator.peek() == '*'||operator.peek() == '+' || operator.peek() == '-') {
                            //나보다 연산순위가 낮은거나 같은게 나올떄까지 pop한 뒤에 후위연산식에 넣어줌
                            while (!operator.isEmpty()&&!( operator.peek() == '(')) {
                                postfix.append(operator.pop());
                            }
                            operator.push(c);
                        }
                        //peek의 연산 순위가 나보다 낮을 때 그냥 연산자 스택에 push
                        else if (operator.peek() == '(') {
                            operator.push(c);
                        } 
                    } 
                    //연산자 스택이 비었을 때는 그냥 연산자 스택에 넣어주기
                    else {
                        operator.push(c);
                    }break;
                     
                case '(':
                    operator.push(c);
                    break;
                    // ')'닫는 괄호를 만났을 때 시작괄호'('를 만날때까지 스택에서 pop -> ')'는 버림(저장x)
                    // operator스택의 top을 pop해서 후위연산식(postfix)에 넣기
                    // '('는 그냥 pop해서 버리기
                case ')':
                    while(!operator.isEmpty() && !(operator.peek()=='(')) {
                        postfix.append(operator.pop());
                    }
                    if(!operator.isEmpty() && operator.peek()=='(')
                        operator.pop();
                    break;
                     
                // 피연산자가 입력됐을 때(숫자들) 일단 후위표현식에 다 넣기
                default:
                    postfix.append(c);
                    break;
                }
 
            }
 
            // operator스택이 빌 때까지 후위표현식에 pop해서 저장해주기
            // 연산자를 postfix의 뒤에 넣어서 후위표기식 완성
            while (!operator.isEmpty()) {
                postfix.append(operator.pop());
            }
         
            System.out.println(postfix);
        
 
    }
 
}