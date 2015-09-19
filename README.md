# Sample JPA project

This project aims to illustrate how different JPA implementations (Hibernate vs EclipseLink) handle using list 
implementation instead of interface.  
JPA specification doesn't require supporting implementations for collections.

To summarize :

- Hibernate doesn't support usage of implementation.
- EclipseLink uses it but does warn that it is not optimal.