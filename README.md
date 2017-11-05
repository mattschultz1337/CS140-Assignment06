<div class="post_region_content note" id="view_quesiton_note">
        
<h1 data-pats="title_text" class="post_region_title">Assignment 6 Part 1</h1>

<div class="post_region_text" id="questionText"><p>Due November 3 at 11:30pm. Part 2 of the assignment will be due November 8</p>
<p>Please resubmit Part 1 with the corrections listed next to <strong>&gt;&gt;ADDITION</strong> below</p>
<p>&nbsp;</p>
<p>Now that we have introduced interfaces, we can improve the way we remove elements from an <tt>ArrayList</tt> while traversing the list.</p>
<p>&nbsp;</p>
<p>Also, with a couple of data structures we can simplify the coding of compareTo, eliminating this code: <a href="https://d1b10bmlvqabco.cloudfront.net/attach/j2pqenz45a72r/iju6iqt2h4n48o/j9ad4z4lh37w/compareTo.txt" target="_blank" rel="noreferrer">compareTo.txt</a>, that I was thinking of having you write.</p>
<p>&nbsp;</p>
<p>We are simplifying the classification of triangles by forcing integer sides. The allows testing for equality without needing a "DELTA". It also prevents there being a right-angled triangle that is isosceles.</p>
<p>&nbsp;</p>
<p>All the terms used here can be looked up online by searching.</p>
<p>&nbsp;</p>
<p>Work in the package <tt>assignment06</tt>. Make a class <tt>TriangleClassifier</tt>. The imports are <tt>java.util.ArrayList, java.util.HashMap, java.util.Iterator, java.util.Map</tt>. This is a utility class that only has static methods and fields. Make a private static field <tt>triDesc</tt> that is an array of String, with the elements:&nbsp;<em>"Equilateral Triangle", "Acute-angled Isosceles Triangle", "Obtuse-angled Isosceles Triangle", "Acute-angled Scalene Triangle", "Right-angled Scalene Triangle", "Obtuse-angled Scalene Triangle"</em>. Make a private static field <tt>number</tt> of type <tt>Map&lt;String, Integer&gt;</tt>, instantiated as a <tt>HashMap</tt>.</p>
<p>&nbsp;</p>
<p>Use a <em>static block</em> to populate <tt>number</tt></p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="kwd">static</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
	</span><span class="kwd">in</span><span class="pln"> a </span><span class="kwd">for</span><span class="pln"> loop to go through triDesc </span><span class="kwd">with</span><span class="pln"> 
	an index i</span><span class="pun">,</span><span class="pln"> put the key triDesc</span><span class="pun">[</span><span class="pln">i</span><span class="pun">]</span><span class="pln"> </span><span class="kwd">in</span><span class="pln"> 
	the map number </span><span class="kwd">with</span><span class="pln"> value i 
</span><span class="pun">}</span></pre>
<p>&nbsp;</p>
<p>Write a method <tt>public static String classify(int a, int b, int c)</tt>, which throws <tt>IllegalArgumentException</tt> with the message <em>"Invalid Triangle (" + a + ", " + b + ", " + c + ")"</em> if any of <tt>a</tt>, <tt>b</tt>, or <tt>c</tt> is 0 or negative or if any of <tt>a</tt>, <tt>b</tt>, or <tt>c</tt> is greater than or equal to the sum of the other two [these a 6 tests, that can be separated by ||).</p>
<p>&nbsp;</p>
<p>After that, return <tt>triDesc[0]</tt> is all three sides are equal. Return <tt>triDesc[1]</tt> if two sides are equal and the square of the non-equal side is less than the sum of the squares of the two equal sides (for example <tt>c*c &lt; a*a + b*b</tt> but there are 2 other cases). You MUST use <tt>a*a, b*b</tt> etc, because Math.pow(a,2) will introduce this inaccuracies associated with doubles. Return <tt>triDesc[2]</tt> if two sides are equal and the square of the non-equal side is greater than the sum of the squares of the two equal sides (for example <tt>c*c &gt; a*a + b*b</tt> but there are 2 other cases). Note that equality is impossible because one of the sides would have to be a multiple of the non-integer √2.</p>
<p>&nbsp;</p>
<p>Continuing:</p>
<p>Return <tt>triDesc[3]</tt> if for each of the three sides, the square of that side is less than the sum of the squares of the other sides. Return <tt>triDesc[4]</tt> if there is one side, whole square is equal to the sum of the squares of the other sides. After that return <tt>triDesc[5]</tt>.</p>
<p>&nbsp;</p>
<p>Inside <tt>TriangleClassifier</tt>, make a public nested class (static class) <tt>Triple</tt> that implements <tt>Comparable&lt;Triple&gt;</tt>. Give <tt>Triple</tt> 3 private int fields <tt>a</tt>, <tt>b</tt>, and <tt>c</tt>. Give <tt>Triple</tt> the <tt>toString</tt> method that returns <tt>classify(a,b,c)</tt>. Provide the <tt>compareTo</tt> method that returns <tt>number.get(toString())</tt> <em>minus</em> the corresponding value for <tt>arg0</tt>.</p>
<p>&nbsp;</p>
<p><em>Outside</em> <tt>Triple</tt> but inside <tt>TriangleClassifier</tt> provide a method <tt>public static Triple createTriple(int a, int b, int c)</tt> that makes a <tt>Triple</tt>, sets the values of <tt>a</tt>, <tt>b</tt> and <tt>c</tt> in that Triple by direct assignment and returns the <tt>Triple</tt> object you just made.</p>
<p>&nbsp;</p>
<p>Now for the proper way to remove things from <tt>ArrayLists</tt>:</p>
<p>&nbsp;</p>
<p>Make a method <tt>public static void removeScalene (ArrayList&lt;Triple&gt; list)</tt>. It will remove all the <tt>Triple</tt>s that are classified as scalene triangles.</p>
<p>&nbsp;</p>
<p>First make an Iterator: <tt>Iterator&lt;Triple&gt; iter = list.iterator();</tt></p>
<p>&nbsp;</p>
<p>While <tt>iter.hasNext()</tt>, make a <tt>Triple t</tt> equal to<tt> iter.next()</tt>. If the <tt>t.toString</tt> contains <em>"Scalene" </em>(yes, String has a contains method), remove<tt> t</tt> from the list using<tt> iter.remove()</tt>.</p>
<p>&nbsp;</p>
<p>Now, remove() is not provided for every collection that developers may write but it is implemented for ArrayLists.</p>
<p>&nbsp;</p>
<p>Write a class Tester with the following imports for convenience:</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">ArrayList</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> java</span><span class="pun">.</span><span class="pln">util</span><span class="pun">.</span><span class="typ">Collections</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> assignment06</span><span class="pun">.</span><span class="typ">TriangleClassifier</span><span class="pun">.</span><span class="typ">Triple</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> assignment06</span><span class="pun">.</span><span class="typ">TriangleClassifier</span><span class="pun">.</span><span class="pln">createTriple</span><span class="pun">;</span><span class="pln">
</span><span class="kwd">import</span><span class="pln"> </span><span class="kwd">static</span><span class="pln"> assignment06</span><span class="pun">.</span><span class="typ">TriangleClassifier</span><span class="pun">.</span><span class="pln">removeScalene</span><span class="pun">;</span></pre>
<p>&nbsp;</p>
<p>In the main method you can now make an <tt>ArrayList&lt;Triple&gt;</tt> and make elements for the list using <tt>createTriple(3, 4, 5)</tt>, for example. Without the third and fourth imports you would need notation such as <tt>TriangleClassifier.Triple t = TriangleClassifier.createTriple(3,4,5);</tt> so the imports save typing.</p>
<p>&nbsp;</p>
<p>In the test add at least one Triple of each the 6 different triangle types and in a different order to the Strings in the array <tt>triDesc</tt>. <a href="https://www.geogebra.org/m/JHgTXKrt" target="_blank" rel="noreferrer"><strong>You may or may not find this link useful.</strong></a></p>
<p>&nbsp;</p>
<p>Then print your list, call Collections.sort on the list and print it again to see the triangles are now listed in the order given in the array <tt>triDesc</tt>. Finally call <tt>removeScalene</tt> on the list and print the remaining list to see that all the scalene triangles were removed.</p>
<p>&nbsp;</p>
<p>Building our own Iterator for a tree like structure (but without implementing remove!)<br><br>Make an interface <tt>MComp</tt> than extends <tt>Iterable&lt;MComp&gt;</tt>. This interface defines 8 default methods and each throws <tt>UnsupportedOperationException()</tt>. The methods are <tt>void add(MComp mComp), void remove(MComp mComp), MComp getChild(int i), String getName(), String getDescription(), double getPrice(), boolean isVegetarian(), void print()</tt>. Note that a class that implements <tt>MComp</tt> must implement<tt> iterator()</tt> from <tt>java.lang.Iterable</tt>.</p>
<p><strong>&gt;&gt;ADDITION: Also give <tt>MComp</tt> a method<tt> default void pushToStack(Stack&lt;Iterator&lt;MComp&gt;&gt; stack)</tt> that also throws the same exception as the others above.</strong></p>
<p>&nbsp;</p>
<p>Make a class <tt>Menu</tt> that implements <tt>MComp</tt>. The private fields are two Strings <tt>name</tt> and <tt>description</tt> and <tt>ArrayList&lt;MComp&gt; comps</tt>, instantiated as an empty list. The constructor has 2 parameters to set the String fields. Override <tt>add</tt> to add <tt>mComp</tt> to <tt>comps</tt>, override <tt>remove</tt> to remove <tt>mComp</tt> from <tt>comps</tt>, override <tt>getChild(i)</tt> to return <tt>comps.get(i)</tt>, provide getters for <tt>name</tt> and <tt>description</tt>, override iterator to return new CompositeIterator(comps.iterator()).</p>
<p><strong>&gt;&gt;ADDITION: Override the method <tt>pushToStack</tt>, to have the line <tt>stack.push(comps.iterator());</tt></strong></p>
<p>We will define the CompositeIterator next. The last method we need to override is <tt>print():</tt></p>
<p>&nbsp;</p>
<p>println&nbsp;<em>"\n" + getName()</em>, println&nbsp;<em>", " + getDescription()</em>, println&nbsp;<em>"----------------------------"</em></p>
<p><strong>&gt;&gt;ADDITION: STOP the print() method HERE</strong></p>
<p>&nbsp;</p>
<p><strong>&gt;&gt;ADDITION: DELETION</strong> REMOVE THE REST OF the print() method <span style="text-decoration:line-through">Get the iterator for comps: <tt>Iterator&lt;MComp&gt; iter = comps.iterator();</tt></span></p>
<p><span style="text-decoration:line-through">while <tt>iter.hasNext()</tt> call <tt>iter.next().print()</tt>.</span></p>
<p>&nbsp;</p>
<p>Make a class <tt>CompositeIterator</tt> that implements <tt>Iterator&lt;MComp&gt;</tt>. The field will be a <tt>java.util.Stack</tt>, which is a last-in, first-out data structure provided in the Java library. The private field is <tt>Stack&lt;Iterator&lt;MComp&gt;&gt; stack = new Stack&lt;&gt;(). </tt>The constructor has<tt> Iterator&lt;MComp&gt; iterator</tt> as its parameter and in the code, iterator is pushed on the stack:<tt> stack.push(iterator);</tt></p>
<p>An iterator needs the <tt>public boolean hasNext()</tt> method:</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="kwd">if</span><span class="pln"> stack</span><span class="pun">.</span><span class="pln">empty</span><span class="pun">()</span><span class="pln"> </span><span class="kwd">then</span><span class="pln"> </span><span class="kwd">return</span><span class="pln"> </span><span class="kwd">false</span><span class="pln">
</span><span class="com">//exam the top iterator in the stack</span><span class="pln">
</span><span class="typ">Iterator</span><span class="pun">&lt;</span><span class="typ">MComp</span><span class="pun">&gt;</span><span class="pln"> iterator </span><span class="pun">=</span><span class="pln"> stack</span><span class="pun">.</span><span class="pln">peek</span><span class="pun">();</span><span class="pln">
</span><span class="kwd">if</span><span class="pln"> </span><span class="pun">!</span><span class="pln">iterator</span><span class="pun">.</span><span class="pln">hasNext</span><span class="pun">()</span><span class="pln"> </span><span class="kwd">then</span><span class="pln"> call stack</span><span class="pun">.</span><span class="pln">pop</span><span class="pun">()</span><span class="pln"> </span><span class="pun">(</span><span class="pln">to </span><span class="kwd">throw</span><span class="pln"> away that exhausted iterator</span><span class="pun">)</span><span class="pln"> </span><span class="kwd">and</span><span class="pln"> </span><span class="kwd">return</span><span class="pln"> hasNext</span><span class="pun">()</span><span class="pln"> </span><span class="pun">(</span><span class="kwd">this</span><span class="pln"> </span><span class="kwd">is</span><span class="pln"> a recursive call that will see </span><span class="kwd">if</span><span class="pln"> the </span><span class="kwd">next</span><span class="pln"> iterator left on the stack has any elements </span><span class="kwd">in</span><span class="pln"> it</span><span class="pun">)</span><span class="pln">
after that </span><span class="kwd">if</span><span class="pln"> statement </span><span class="kwd">return</span><span class="pln"> </span><span class="kwd">true</span><span class="pun">.</span></pre>
<p>Say that we are giving up on provide a remove in this iterator:</p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="kwd">public</span><span class="pln"> </span><span class="kwd">void</span><span class="pln"> remove</span><span class="pun">()</span><span class="pln"> </span><span class="pun">{</span><span class="pln">
	</span><span class="kwd">throw</span><span class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span class="typ">UnsupportedOperationException</span><span class="pun">();</span><span class="pln">
</span><span class="pun">}</span></pre>
<p>Now we have to provide <tt>public MComp next()</tt>:</p>
<p><strong>(&gt;&gt;ADDITION: THERE IS ONE LINE TO CHANGE IN THIS METHOD)</strong></p>
<p>&nbsp;</p>
<pre style="white-space: -moz-pre-wrap;white-space: -o-pre-wrap;white-space: pre-wrap;word-wrap: break-word;" class="prettyprint"><span class="kwd">if</span><span class="pln"> </span><span class="pun">!</span><span class="pln">hasNext</span><span class="pun">()</span><span class="pln"> </span><span class="kwd">return</span><span class="pln"> </span><span class="kwd">null</span><span class="pln"> </span><span class="pun">(</span><span class="kwd">by</span><span class="pln"> the way never call </span><span class="kwd">next</span><span class="pln"> on an iterator without checking hasNext</span><span class="pun">)</span><span class="pln">
</span><span class="com">//get the iterator on top of the stack</span><span class="pln">
</span><span class="typ">Iterator</span><span class="pun">&lt;</span><span class="typ">MComp</span><span class="pun">&gt;</span><span class="pln"> iterator </span><span class="pun">=</span><span class="pln"> stack</span><span class="pun">.</span><span class="pln">peek</span><span class="pun">();</span><span class="pln">
</span><span class="typ">Read</span><span class="pln"> the </span><span class="kwd">next</span><span class="pln"> element</span><span class="pun">:</span><span class="pln"> </span><span class="typ">MComp</span><span class="pln"> comp </span><span class="pun">=</span><span class="pln"> iterator</span><span class="pun">.</span><span class="kwd">next</span><span class="pun">();</span><span class="pln"> 
</span><span class="pun">&gt;&gt;&gt;&gt;</span><span class="pln">ADDITION</span><span class="pun">:</span><span class="pln"> CHANGE THE NEXT LINE
</span><span class="kwd">if</span><span class="pln"> </span><span class="pun">(</span><span class="pln">comp </span><span class="kwd">instanceof</span><span class="pln"> </span><span class="typ">Menu</span><span class="pun">)</span><span class="pln"> comp</span><span class="pun">.</span><span class="pln">pushToStack</span><span class="pun">(</span><span class="pln">stack</span><span class="pun">);</span><span class="pln">
</span><span class="kwd">return</span><span class="pln"> comp</span></pre>
<p>&nbsp;</p>
<p>Make a class <tt>NullIterator</tt> that implements Iterator&lt;MComp&gt;: <tt>next</tt> returns <tt>null</tt>, <tt>hasNext()</tt> returns <tt>false</tt> and <tt>remove</tt> throws <tt>UnsupportedOperationException()</tt></p>
<p>&nbsp;</p>
<p>Make a class <tt>MenuItem</tt> that implements <tt>MComp</tt>. The private fields are<tt> name</tt> and <tt>description</tt> that are<tt> String</tt>, <tt>vegetarian</tt> that is a <tt>boolean</tt> and <tt>price</tt> that is a <tt>double</tt>. The constructor sets the value of all 4 fields. There are getters for all four fields--the getter method for a boolean is called <tt>isVegetarian</tt>. The method <tt>iterator</tt> returns a new <tt>NullIterator()</tt>. The <tt>print</tt> method does the following:</p>
<p>&nbsp;</p>
<p>print (<em>not</em> println) <em>"\t" + getName()</em>, if isVegetarian() print <em>"(v)"</em>, then println <em>", " + getPrice()</em> and println <em>"\t\t--" + getDescription()</em></p>
<p>&nbsp;</p>
<p>Here is a picture from a book that shows where <tt>Menus</tt> and <tt>MenuItems</tt> appear in an example of the <em>Composite</em> design pattern. <a href="https://d1b10bmlvqabco.cloudfront.net/attach/j2pqenz45a72r/iju6iqt2h4n48o/j9bywf3rwnd8/menus.JPG" target="_blank" rel="noreferrer">menus.JPG</a></p>
<p>&nbsp;</p>
<p>Make a class <tt>Server</tt> that can provide the menus to customers. There is a private <tt>MComp</tt> field called <tt>allMenus</tt>. The constructor has a parameter that provides the value of <tt>allMenus</tt>.</p>
<p><strong>&gt;&gt; ADDITION CHANGE printMenu, DELETE THE OLD printMenu()</strong>.</p>
<p>The method <tt>public void printMenu()</tt>.</p>
<p>Add a method public void printMenu() that starts out printing "\nALL MENUS\n----" and then calls print on all the elements in allMenus by using <tt>for (MComp comp : allMenus)</tt> instead of using an <tt>Iterator</tt> and calling print() on each comp.</p>
<p>&nbsp;</p>
<p>Add a method public void printVegetarianMenu() that starts out printing "\nVEGETARIAN MENU\n----" and then calls print on all the vegetarian elements in allMenus (use instanceof MenuItem since Menu inherits the isVegetarian method that throws an exception) . NOTE THAT since <tt>MComp</tt> is <tt>Iterable</tt> you can use <tt>for (MComp comp : allMenus)</tt> instead of using an <tt>Iterator</tt>.</p>
<p>&nbsp;</p>
<p>Here is a tester program corresponding to the picture: <a href="https://d1b10bmlvqabco.cloudfront.net/attach/j2pqenz45a72r/iju6iqt2h4n48o/j9c14w42d6ai/MCompTester.txt" target="_blank" rel="noreferrer">MCompTester.txt</a></p>
<p>&nbsp;</p>
<p>Output <strong>(NOW WITHOUT DUPLICATES!)</strong>: (I added -- before the description) <a href="https://d1b10bmlvqabco.cloudfront.net/attach/j2pqenz45a72r/iju6iqt2h4n48o/j9irtl9n8idl/OUTPUT.txt" target="_blank" rel="noreferrer">OUTPUT.txt</a></p>
<p>&nbsp;</p>
<p>Add static methods to MCompTester: <tt>public static MenuItem cheapest(MComp menus)</tt> that returns a <tt>MenuItem</tt> that has the lowest cost and similarly <tt>public static MenuItem dearest(MComp menus</tt>) that returns a <tt>MenuItem</tt> that has the greatest cost, also a method <tt>public static MenuItem longestDescr(MComp menus</tt>) that returns a <tt>MenuItem</tt> that has the longest description.</p>
<p>&nbsp;</p>
<p>Provide a JUnit test class to test the last thee method you just wrote [in the JUnit test, use <tt>MCompTester.makeTest()</tt> to provide an <tt>MComp</tt> object for testing.</p>
<p>&nbsp;</p><br></div>
<div data-pats="folders" class="post_region_folders">
  <span>
    <span data-pats="folders_item"><a data-pats="link" href="#" class="tag folder" onclick="PEM.fire('filterFeed', {filter:'folder',folder:'assignment6'});return false;">assignment6</a></span>
  </span>
</div>
<div class="attachments" style="display:none;">
  <div class="attachments_divider"></div>
  <div class="attachments_count">Attachments:</div>
  <table class="attachments_list">
    
  </table>
</div>
<div class="post_region_message_wrapper">
  <div id="endorse_text"></div>
  
  
  
