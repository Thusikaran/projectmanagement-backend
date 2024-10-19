# projectmanagement-backend

## Overview

## Project step by step
### create signup ,login api
  - spring security configration
  - custom user details
  - user model
  - user repository
  - signup
  - jwt configration
  - login
### Create User Entity
  - id (primarykey , AUTO Generation )
### Create user Repository
  extents JpaRepository<User ,  Long>
  - create method "User findByEmail(String email);"
### create new service 
   - CustomeUserDetailsImpl
### create new Controller
- AuthController (signin and signup metghod)
### create model
- Project
- Chat
- Message
- Issue
- Comment
### Project api
