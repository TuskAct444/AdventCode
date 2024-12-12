package main;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdventDay33 {

    public static void main(String[] args) {
        String input = "%how()how():?:mul(766,746)*@mul(364,566)-< who()(*':mul(999,344)*/select()--mul(672,593){how())<mul(73#)()@+mul(83,507) mul(373,176)who()^'('mul(584,620)what()#//!do()mul(103,225) ~;;'why()*~mul(187,119)+/]mul+(select()%mul(874,888)}when():how()mul(583,992)^~[[what()don't()() {from() ]]((mul(68,200)^?what()who()*[mul(932,283)['$mul(189,932)< ,mul(652,125))$how()where()how()^how()#]mul(501,335)!when():+%])!<mul(551,924)+,#why()) $mul(118,951)@])/'who()mul(858,212) who(){-how()!don't())mul(746,402)/%}where()mul(629,312)];*~#]mul(680,3)what()how()what()'}?'@where();mul(263,427)#$$from()-what()mul(698,847)#(;$!$<+mul;why())what())$select()mul(482,169)-where()mul(546,79)mul(796,632)how()select()when()&$/*mul(749,226)-%what()>(who()'/<when()mul(932,346)?where(),^^>mul(722,627)>-?mul(231,501)~}#!mul(694,751)when()how()- where(202,572)select() }*^mul(17,75):+'what(),&mul(413,505)mul(113,65)[-+{,[mul(83,722)((mul(475,980)mul(588,832):/;)what()/+mul(103,764)?{$:?{{+:select()mul(583,487)mul(757,133)why()??mul(47,54)<]>select()>^?$mul(201,196)$from()]^~#where()mul(494,817)]?//-#select()%+mul(444,319)%?from()mul(316,303)}-~'<<-when()when()mul(350,810)mul(557,674)~##(select()$mul(97,781)who()(>>' >!),mul(473,488)who(290,952)mul(33,630)why()>do():)<select()~ mul(571,144){mul(931,78)mul(200,845)how()#select(403,528)mul(741,613)mul(54,465)@;(<[>mul(267,367)+/who())^select()^from()$!mul(409,900)*what()[)]who())[+where()mul(309,751)~don't()!mul(165,206)mul(113,418)]from(),'&do()select()/*:)]!mul(272,138) mul(211,851)]/$mul(916,846)mul(203,199)mul(40,428){&*from()%mul(305,353)? >}where()<what()(mul(904,794)+$from()-,/{mul(712,685)@ what(628,776)why(){;:;-mul(909,11){<,,mul(287,272),?),>%mul(397,337)]!mul(352,23)@don't()where()^{from()mul(804,392)${<}!mul(392,298),>>mul(572,89)+why()$*;when())#where()$mul(458,495);mul(375,386)~from()mul(429,704),{*%select()$who()]mul(442,21)#why()@?!mul(659,81)when()<($%^&&don't()!mul(934,729)/<[:how(288,214)'mul(971,226);+!%!mul(465,736)/]&%&^what(),+mul(613,544)-/from()what() },<-!mul(906,152)[who()&when()select()mul(612,56)~&<')/!mul(247,423)from()[{&who()mul(979,442)[mul(319,494)~%/+mul(781,251);<>)who()%from()[from()mul(27,381)}+)what()%/select(),,mul(324,64)mul(938,422)how():@>}:%'/&mul(388,707)]@mul(98,712)~who()$%@?(what()from()who()mul(161,906)~where():#mul(198,30)why() ~!>how()['-who()mul(5,68)what()<%%{mul(829,126):,mul(509,883)mul(142,939)do()#>mul(53,112)!(what()/?do()(,how()%mul(523,469) who(){what()'/mul(356,713)~@;!~ ->mul(309,932)where()mul(93,190)where()select()){how()}why()mul(202,888))!,{{:what(),~mul(591,813)select()<&{[&mul(652,199)";
        
        // Call the function to calculate the sum
        long sum = calculateSum(input);
        System.out.println("The sum of the results from all enabled multiplications is: " + sum);
    }

    public static long calculateSum(String input) {
        long sum = 0;
        boolean enableMul = true; // Initially, mul is enabled

        // Define regex pattern to match mul(x, y) expressions
        Pattern mulPattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");
        
        // Match 'do()' and 'don't()' instructions
        Stack<Boolean> mulStack = new Stack<>();
        mulStack.push(enableMul); // Initially push true for enabled mul
        
        Matcher matcher = mulPattern.matcher(input);
        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            long result = (long) x * y;

            // Check the current state of mul (enabled/disabled)
            if (mulStack.peek()) {
                sum += result;
            }

            // Now check for 'do()' and 'don't()' instructions
            if (input.contains("do()")) {
                mulStack.push(true); // Enable future mul operations
            } else if (input.contains("don't()")) {
                mulStack.push(false); // Disable future mul operations
            } else {
                // If neither 'do()' nor 'don't()' appears, continue with the current state
                mulStack.push(mulStack.peek());
            }
        }

        return sum;
    }
}
