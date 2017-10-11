<%@page pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.TreeSet" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="edu.aabu.security.*" %>

<div class="nprint">
<script type="text/javascript" language="JavaScript1.2">
<!--
stm_bm(["menu3b81",800,"/nara/menudhtml","blank.gif",0,"","",2,0,250,200,1000,1,0,0,"","",0,0,1,2,"default","hand",""],this);
stm_bp("p0",[0,4,0,0,0,0,18,7,100,"",-2,"",-2,50,0,0,"#799BD8","transparent","bgline2.gif",3,0,0,"#000000","",-1,-1,0,"transparent","",0,"",-1,-1,0,"transparent","",0,"",-1,-1,0,"transparent","",0,"",-1,-1,0,"transparent","",0,"","","","",0,0,0,0,0,0,0,0]);
stm_ai("p0i0",[0,"  الصفحة الرئيسية","","",-1,-1,0,"/nara/news.jsp","_self","","the main page","/nara/images/ho.png","/nara/images/ho.png",25,23,0,"","",0,0,0,2,1,"#FFFFF7",1,"#B5BED6",1,"","",2,3,0,0,"#FFFFF7","#000000","#FFFFFF","#FFFF00"," 9pt Tahoma"," 9pt Tahoma",0,0],140,25);
stm_ai("p0i1",[6,1,"#000000","",-1,-1,0]);
stm_aix("p0i2","p0i0",[0,"  قائمة البرامج","","",-1,-1,0,"","_self","","","ico2.gif","bullet_172.gif",12,12,1,"060420arrow2.gif","060420arrow3.gif",10,5],140,25);
stm_bp("p1",[1,1,0,0,0,0,18,28,100,"",-2,"",-2,50,0,0,"#799BD8","transparent","bgline2.gif",3,0,0,"#000000"]);
<%
	String prog_url = "" ;
	final String context = "/nara/" ;
	int loop_count = 0 ;
	int level_1 = 0 , level_2 = 0 ;
	String seq2 = null,
	title = null;
	String img_arr1 = "";
	String img_arr2 = "";
	try 
	{
		int [] L = new int[5];
		int [] old_l = new int[5];
		int [] nxt = new int[5];
		int cLevel = 1 ;
		boolean firstLoop = true ;
		boolean last = false ;
		Applications app = null ;
		Applications app1 = null ;
		TreeSet<Applications> hap = (TreeSet<Applications>)session.getAttribute("userApplications");
		Iterator<Applications> it = hap.iterator() ;
		Iterator<Applications> it1 = hap.iterator() ;
		if(it1.hasNext())
		{
			app1 = it1.next();
		}
		while(it.hasNext())
		{
			if(it1.hasNext())
			{
				app1 = it1.next();
				nxt[0] = app1.getApplicationsPK().getLevel1();
				nxt[1] = app1.getApplicationsPK().getLevel2();
				nxt[2] = app1.getApplicationsPK().getLevel3();
				nxt[3] = app1.getApplicationsPK().getLevel4();
				nxt[4] = app1.getApplicationsPK().getLevel5();
			}else{ 
				
				last = true ;
			}
			
			app = it.next();
			prog_url = app.getProgUrl() ;
			if( prog_url.length() != 0 ){
				prog_url = context + prog_url ;
			}     
			if(firstLoop)
			{
				old_l[0] = app.getApplicationsPK().getLevel1();
				old_l[1] = app.getApplicationsPK().getLevel2();
				old_l[2] = app.getApplicationsPK().getLevel3();
				old_l[3] = app.getApplicationsPK().getLevel4();
				old_l[4] = app.getApplicationsPK().getLevel5();

			}
			L[0] = app.getApplicationsPK().getLevel1();
			L[1] = app.getApplicationsPK().getLevel2();
			L[2] = app.getApplicationsPK().getLevel3();
			L[3] = app.getApplicationsPK().getLevel4();
			L[4] = app.getApplicationsPK().getLevel5();
			if((L[cLevel] != 0 ) && (L[cLevel-1] == old_l[cLevel-1]) && !firstLoop)
			{
				loop1: while(cLevel < 4)
				{
					if((L[cLevel] != 0 ) )
					{
						%>	
						stm_bp("sub",[1,1,0,0,0,0,18,28,100,"",-2,"",-2,50,0,0,"#799BD8","transparent","bgline2.gif",3,0,0,"#000000"]);
						<%
						cLevel++ ;
					}
					else 
					{
						break loop1;
					}
				}
			}
			else
			{
				w: while(cLevel > 1)
				{
					if(L[cLevel] == 0 && (L[cLevel-1] == 0))
					{
						%>
						stm_ep();
						<%
						cLevel-- ;
					}
					else 
					{
						%>
						<%
						break w;
					}
				}
			}
			out.println(nxt[cLevel-1]+"|"+L[cLevel-1]+"|"+nxt[cLevel]+"|"+L[cLevel]+"|"+last );
			if ( ( nxt[cLevel-1] == L[cLevel-1] ) && ( nxt[cLevel] != 0 ) && ( L[cLevel] == 0 ) && !( last ) )
			{
				img_arr1 = "060420arrow2.gif" ;
				img_arr2 = "060420arrow3.gif" ;
			}else{
				img_arr1 = "";
				img_arr2 = "";
			}						
			%>
stm_aix("sub","p0i0",[0,"<%=" "+app.getArabicName()%>","","",-1,-1,0,"<%=prog_url%>","_self","","","ico2.gif","bullet_172.gif",12,12,0,"<%=img_arr1%>","<%=img_arr2%>",10,5,0,2,1,"#FFFFF7",1,"#B5BED6",1,"","",3],0,23);
			<%
			old_l[0] = L[0];
			old_l[1] = L[1];
			old_l[2] = L[2];
			old_l[3] = L[3];
			old_l[4] = L[4];
			firstLoop = false ;
		}
		w: while(cLevel > 1)
		{
			%>
			<%
			cLevel-- ;
		}
	}catch(Exception e)
	{
		out.print("Error : " + e.getMessage()) ;
	}
	%>
stm_ep();
stm_ep();
stm_em();
//-->
</script>
</div>