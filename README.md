# Richard-And-The-Richettes-Helping-Hand-UI

## Description:
An app created to help clients find people to complete odd jobs for them without the hassle of going through a hiring agency. Clients will be able to post a request (including a description, job title, and deadline) and Helpers will be able to place bids on the job. The client will choose from the available bids and the request will be marked as pending. The request will be marked as closed once the job has been completed.

## Executive Summary:
A user will be able to sign up as a Client or a Helping Hand. Clients will be able to submit requests for tasks, with deadlines, they need help accomplishing. Helping Hands will be able to place bids on requests, setting a price they deem as fair for the task. Clients will then choose the bid they want and approve it.
  
### User Stories:
#### Client: 
  1. Log in/register
  2. Submits a request, specifying the type (car wash, house work, etc)
  3. Submits payment for job 
  4. Submit reviews for the Helping Hand(Star rating?  
  6. View past and active requests
  7. Can view/accept/deny bids on requests
#### Helping Hand: 
  1. Log in/register
  2. Places bids on jobs
  3. Can decline jobs after accepting   
  a. Cannot cancel within 24 hours
  6. High amount of jobs completed and high rating = preferred operative  
  a. Some symbol, different than the client  
  7. Submit review of client  
  8. View past and upcoming jobs  

### Stretch Goals:
1. Client:  
  a. Edit address, contact info and password  
  b. Calendar function  
  c. View own rating  
  a. High rating and high request amount = preferred client status  
  b. Some star on profile  
2. Helping Hand:  
  a. Edit address, contact info and password  
  b. View own rating  
  c. High rating and high request amount = preferred client status  
  d. Some star on profile  



### Classes: Client and Helping Hand

### Tables:
1. Client  
  a. Client ID  
  b. Username  
  c. Password  
  d. Full Address  
  e. Contact Info  
  f. Rating (5 star default)  
2. Helper  
  a. helper_id  
  b. Username  
  c. Password  
  d. Full Address  
  e. Contact Info  
  f. Rating (5 star default)  
3. Request  
  a. Job ID  
  b. Title  
  c. Client user  
  d. Client Address  
  e. Description  
  f. Deadline  
  g. Client Rating  
  h. Mission accomplished(boolean - default false)  
4. Bids  
  a. Bid ID  
  b. Links with Request via Job ID  
  c. Links with Helping Hand via User  
  d. Bid - amount  
5. Request Bid  
