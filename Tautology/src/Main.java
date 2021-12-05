import java.util.*;
public class Main{
    static char[] exp;
    static int pos;
    static int[] lookup = new int[26];
    static int state;
    static int varcount;
    static boolean yes(char type) {
        return (state&(1<<lookup[type-'a']))!=0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        loop:while (T-->0) {
            exp = sc.next().toCharArray();
            lookup = new int[26];
            Arrays.fill(lookup,-1);
            pos = 0;
            varcount=0;
            Expression full = parse();
            for (state=(1<<varcount)-1; state>=0; state--) {
                if (!full.yes()) {
                    System.out.println("NO");
                    continue loop;
                }
            }
            System.out.println("YES");
        }
    }
    static Expression parse() {
        Expression ret = new Expression();
        ret.type=exp[pos++];
        switch (ret.type) {
            case 'C':
            case 'D':
            case 'I':
            case 'E':
                ret.left=parse();
                ret.right=parse();
                break;
            case 'N':
                ret.left=parse();
                break;
            default:
                if (lookup[ret.type-'a']==-1) {
                    lookup[ret.type-'a']=varcount++;
                }
        }
        return ret;
    }
} class Expression {
    char type;
    Expression left, right;
    boolean yes() {
        switch (type) {
            case 'C': return left.yes() && right.yes();
            case 'D': return left.yes() || right.yes();
            case 'I': return !left.yes() || right.yes();
            case 'E': return left.yes() == right.yes();
            case 'N': return !left.yes();
            default:
                return Main.yes(type);
        }
    }
}