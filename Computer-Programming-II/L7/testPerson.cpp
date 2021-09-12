//----------------------------------------------------------------------------
//
//-------------------------------- Personality -------------------------------
// 
//----------------------------------------------------------------------------
//
//  Program Name: Person.cpp
//
//  This is a test program for investigating use of pointers in class design
//  and implementation.
//
//  This program contains a partial class declaration and definition for a
//  Person class
//
//----------------------------------------------------------------------------
//
//  Author:         P Zoski, JL Popyack
//  Date:           05/10/3
//
//----------------------------------------------------------------------------


	#include <iostream>
	#include <string>
	#include <ciso646>
	using namespace std ;

	
//----------------------------------------------------------------------------
//
//  Person class
//    Declaration
//
//----------------------------------------------------------------------------


	class Person
	{
		public:

		//------------------------------------------------------
		//----- Constructors -----------------------------------
		//------------------------------------------------------

			Person() ;
			Person(string name) ;
			~Person() ;

		//------------------------------------------------------
		//----- Inspectors -------------------------------------
		//------------------------------------------------------

			string getName() ;
			Person * getSpouse() ;
			
		//------------------------------------------------------
		//----- Mutators ---------------------------------------
		//------------------------------------------------------

			bool marry(Person & p) ;
            bool addSister(Person & p) ;
            bool addBrother(Person & p) ;
        bool addSon(Person & p) ;
        void printChildren() ;
        //------------------------------------------------------
        //----- Facilitator ------------------------------------
        //------------------------------------------------------
            Person toString();
        
			
		private:
			string name_ ;
			Person * spouse_ ;
			Person * son_ ;
			Person * daughter_ ;
            Person * brother_ ;
            Person * sister_ ;
	} ;

	
//----------------------------------------------------------------------------
//
//  Person class
//    Implementation
//
//----------------------------------------------------------------------------


//----------------------------------------------------------------------------
//----- Constructors ---------------------------------------------------------
//----------------------------------------------------------------------------

	Person::Person()
	{ }

	Person::Person(string name)
	{ 
		name_ = name ;
        spouse_ = NULL;
        son_ = NULL;
        daughter_ = NULL;
        brother_ = NULL;
        sister_ = NULL;
	}

	Person::~Person()
	{ }

//----------------------------------------------------------------------------
//----- Inspectors -----------------------------------------------------------
//----------------------------------------------------------------------------

	string Person::getName()
	{ 
		return name_ ;
	}

	Person * Person::getSpouse()
	{ 
		return spouse_ ;
	}

//----------------------------------------------------------------------------
//----- Mutators -------------------------------------------------------------
//----------------------------------------------------------------------------

	bool Person::marry(Person & p)
	{ 
	//----------------------------------------------------------------------------
	// parameter must be passed by reference, otherwise implicit
	// object will marry a copy of p
	//----------------------------------------------------------------------------

		//----------------------------------------------------------------------------
		// can't get married if a Person is already married
		//----------------------------------------------------------------------------
			if (spouse_ != NULL or p.spouse_ != NULL)
				 return false ; 
	     
		//----------------------------------------------------------------------------
		// implicit Person marries person p
		// p marries implicit Person
		//----------------------------------------------------------------------------
			spouse_ = & p; 
			p.spouse_ = this ;  
		
		return true;  
	}

bool Person::addBrother(Person & p)
{
   
    if (brother_ != NULL or p.brother_ != NULL)
        return false ;
    
    brother_ = & p;
    p.brother_ = this ;
    
    return true;  
}

bool Person::addSister(Person & p)
{
    
    if (sister_ != NULL or p.sister_ != NULL)
        return false ;
    
    sister_ = & p;
    p.sister_ = this ;
    
    return true;
}

bool Person::addSon(Person & p)
{
    
    if (son_ != NULL or p.son_ != NULL)
        return false ;
    
    son_ = & p;
    
    return true;
}
void Person::printChildren()
{
    if(brother_!=NULL)
    cout<<"Brother:"<<brother_->getName()<<endl;
    else
    cout<<"Brother=null"<<endl;
    if(sister_!=NULL)
    cout<<"Sister:"<<sister_->getName()<<endl;
    else
    cout<<"Sister=null"<<endl;
    if(son_!=NULL)
    cout<<"Son:"<<son_->getName()<<endl;
    else
    cout<<"Son=null"<<endl;
    if(daughter_!=NULL)
    cout<<"Daughter:"<<daughter_->getName()<<endl<<endl;
    else
    cout<<"Daughterr=null"<<endl<<endl;
    }


	
//----------------------------------------------------------------------------
//
//------------------------------- Main Program -------------------------------
//
//----------------------------------------------------------------------------

	int main(void)
	{
		Person George("George Jetson"), 
		       Jane("Jane Jetson"), 
		       Judy("Judy Jetson"), 
		       Elroy("Elroy Jetson"),
               Hughtron("Hughtron"),
               Dewtron("Dewtron"),
               Loutron("Loutron");
        
        cout << George.getName();
        cout << Jane.getName();
        cout << Judy.getName();
        cout << Elroy.getName()<<endl;
        
        George.marry(Jane);
        cout << George.getSpouse()->getName()<<endl<<endl;
        
        George.addSon(Elroy);
        Elroy.addBrother(Hughtron);
      
        
        George.printChildren();
        Elroy.printChildren();
        Hughtron.printChildren();
        Dewtron.printChildren();
        Loutron.printChildren();
        
		return 0 ;
	}

