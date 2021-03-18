Feature: Search Functionality

Background:
					Given the user is on eBay home page
					
					

Scenario:
				When the user enters a bookname
				And selects the book category
				And clicks the search button
				Then the basic search result should be displayed
				
Scenario:
				When the user moves to the advance search page
				When the user enters a search keyword
				And click the search icon
				Then the advance search result should be displayed
				