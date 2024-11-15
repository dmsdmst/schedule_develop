# Schedule

### API 명세서

## Schedule
| 기능        | Method | URL                    | request | response | 상태코드                     |
|-----------|--------|------------------------|---------|----------|--------------------------|
| 일정 생성     | POST   | /schedule              | 요청 body | 등록 정보    | 201 Created, 400 실패      |
| 전체 일정 조회  | GET    | /schedule              |         | 다건 응답 정보 | 200 정상 조회, 400 실패        |
| 선택 일정 조회  | GET    | /schedule/{scheduleId} |         | 단건 응답 정보 | 200 정상 조회, 404 Not Found |
| 선택 일정 수정  | PATCH  | /schedule/{scheduleId} | 요청 body | 수정 정보    | 200 정상 수정, 404 Not Found |
| 선택 일정 삭제  | DELETE | /schedule/{scheduleId} | 요청 body |          | 200 정상 삭제, 404 Not Found |



#### 1. 일정 생성
/calendar
+ Request
  + Header : Content-Type:application/json
  + Body :

```
{
    "name": "작성자",
    "title": "제목",
    "contents": "내용"
}
```

  | 이름       | 타입     | 설명    | 필수 | 
  |----------|--------|-------|----|
  | name     | String | 작성자명  | O  |
  | title    | String | 일정 제목 | O  |
  | contents | String | 일정 내용 | X  |

+ Response
  + Body :

```
{
    "scheduleId": "아이디",
    "name": "작성자",
    "title": "제목",
    "createdDate": "YYYY-MM-DD HH:mm:ss",
    "updatedDate": "YYYY-MM-DD HH:mm:ss"
}
```
  
  | 이름          | 타입            | 설명      |
  |-------------|---------------|---------|
  | scheduleId  | int           | 일정 고유번호 |
  | name        | String        | 작성자명    |
  | title       | String        | 일정 제목   |      
  | createdDate | LocalDateTime | 생성 일시   |   
  | updatedDate | LocalDateTime | 수정 일시   |   


#### 2. 전체 일정 조회
/calendar
+ Request
  + Parameters :
  
  | 이름          | 타입            | 설명        | 필수 | 
  |-------------|---------------|-----------|----|
  | name        | String        | 작성자명      | X  |      
  | createdDate | LocalDateTime | 조회할 생성 일자 | X  |      


+ Response
  + Body :

```
[
  {
      "scheduleId": "아이디",
      "name": "작성자",
      "title": "제목",
      "createdDate": "YYYY-MM-DD HH:mm:ss",
      "updatedDate": "YYYY-MM-DD HH:mm:ss"
      
  },
  {
      "id": "아이디",
      "name": "작성자",
      "title": "제목",
      "createdDate": "YYYY-MM-DD HH:mm:ss",
      "updatedDate": "YYYY-MM-DD HH:mm:ss"
      
  }
]
```

  
  | 이름          | 타입            | 설명      |
  |-------------|---------------|---------|
  | scheduleId  | int           | 일정 고유번호 |
  | title       | String        | 일정 제목   |
  | name        | String        | 작성자명    |
  | createdDate | LocalDateTime | 생성 일자   |
  | updatedDate | LocalDateTime | 수정 일시   |


#### 3. 선택 일정 조회
/calendar/{scheduleId}

+ Request

+ Response
  + Body :

```
{
    "name": "작성자",
    "title": "제목",
    "contents": "내용",
    "createdDate": "YYYY-MM-DD HH:mm:ss",
    "updatedDate": "YYYY-MM-DD HH:mm:ss"
}
```

  | 이름          | 타입            | 설명    |
  |-------------|---------------|-------|
  | name        | String        | 작성자명  |
  | title       | String        | 일정 제목 |
  | contents    | String        | 일정 내용 |
  | createdDate | LocalDateTime | 생성 일시 |
  | updatedDate | LocalDateTime | 수정 일시 |



#### 4. 선택 일정 수정
/calendar/{scheduleId}

+ Request
  + Parameters :
  
  | 이름       | 타입     | 설명     | 필수 | 
  |----------|--------|--------|----|
  | name     | String | 작성자명   | X  |      
  | title    | String | 수정할 제목 | X  |      
  | contents | String | 수정할 내용 | X  |      


+ Response
  + Body :

```
{
    "name": "작성자",
    "title": "제목",
    "contents": "내용",
    "createdDate": "YYYY-MM-DD HH:mm:ss",
    "updatedDate": "YYYY-MM-DD HH:mm:ss"
}
```

  | 이름          | 타입            | 설명    |
  |-------------|---------------|-------|
  | name        | String        | 작성자명  |
  | title       | String        | 일정 제목 |
  | contents    | String        | 일정 내용 |
  | createdDate | LocalDateTime | 생성 일시 |
  | updatedDate | LocalDateTime | 수정 일시 |

#### 5. 선택 일정 삭제
/calendar/{scheduleId}

+ Request
  + 없음
   

+ Response
  + 없음




## User
| 기능    | Method | URL            | request | response | 상태코드                     |
|-------|--------|----------------|---------|----------|--------------------------|
| 유저 생성 | POST   | /user/join     | 요청 body | 등록 정보    | 201 Created, 400 실패      |
| 유저 조회 | GET    | /user/{userId} |         | 단건 응답 정보 | 200 정상 조회, 404 Not Found |
| 유저 삭제 | DELETE | /user/{userId} |         |          | 200 정상 삭제, 404 Not Found |


#### 1. 유저 생성
/user/join
+ Request
  + Body :

```
{
    "name": "유저 이름",
    "password": "비밀번호",
    "email": "이메일"
}
```

  | 이름       | 타입     | 설명    | 필수 | 
  |----------|--------|-------|----|
  | name     | String | 유저 이름 | O  |
  | title    | String | 비밀번호  | O  |
  | contents | String | 이메일   | X  |

+ Response
  + Body :

```
{
    "userId": "유저 아이디",
    "name": "유저 이름",
    "email": "이메일",
    "createdDate": "YYYY-MM-DD HH:mm:ss",
}
```

  | 이름          | 타입            | 설명      |
  |-------------|---------------|---------|
  | userId      | int           | 유저 고유번호 |
  | name        | String        | 유저 이름   |
  | email       | String        | 이메일     |      
  | createdDate | LocalDateTime | 생성 일시   |   



#### 2. 유저 정보 조회
/user/{userId}

+ Request

+ Response
  + Body :

```
{
    "name": "작성자",
    "title": "제목",
    "contents": "내용",
    "createdDate": "YYYY-MM-DD HH:mm:ss",
    "updatedDate": "YYYY-MM-DD HH:mm:ss"
}
```

  | 이름          | 타입            | 설명    |
  |-------------|---------------|-------|
  | name        | String        | 작성자명  |
  | title       | String        | 일정 제목 |
  | contents    | String        | 일정 내용 |
  | createdDate | LocalDateTime | 생성 일시 |
  | updatedDate | LocalDateTime | 수정 일시 |


#### 3. 유저 정보 삭제
/user/{userId}

+ Request
  + 없음


+ Response
  + 없음




### ERD
