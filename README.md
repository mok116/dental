# springbootDemo

INSERT INTO `clinics` (
    `address`, 
    `name`, 
    `open_hours`
) VALUES
    -- Clinic 1: Downtown Dental
    ('123 Main St, Cityville', 'Downtown Dental', 'Mon-Fri 9:00-17:00'),
    
    -- Clinic 2: Smile Bright Clinic
    ('456 Oak Ave, Townsville', 'Smile Bright Clinic', 'Mon-Sat 8:00-18:00'),
    
    -- Clinic 3: Family Dental Care
    ('789 Pine Rd, Villagetown', 'Family Dental Care', 'Mon-Fri 9:00-16:00, Sat 9:00-13:00'),
    
    -- Clinic 4: Extra for variety
    ('101 Elm St, Hamlet City', 'Healthy Teeth Hub', 'Tue-Sun 10:00-19:00');
    
    
INSERT INTO `dentists` (
    `name`
) VALUES
    -- Dentist 1
    ('Dr. Alice Smith'),
    
    -- Dentist 2
    ('Dr. Bob Johnson'),
    
    -- Dentist 3
    ('Dr. Clara Davis'),
    
    -- Dentist 4
    ('Dr. David Lee'),
    
    -- Extra Dentist for variety
    ('Dr. Emma Wilson');
    
INSERT INTO `schedules` (
    `clinic_id`, 
    `dentist_id`, 
    `end_time`, 
    `start_time`, 
    `day_of_week`
) VALUES
    -- Dentist 1 at Clinic 1 on Monday morning
    (1, 1, '12:00:00.000000', '09:00:00.000000', 'Monday'),
    
    -- Dentist 2 at Clinic 2 on Tuesday afternoon
    (2, 2, '17:00:00.000000', '13:00:00.000000', 'Tuesday'),
    
    -- Dentist 3 at Clinic 1 on Wednesday morning
    (1, 3, '13:00:00.000000', '09:00:00.000000', 'Wednesday'),
    
    -- Dentist 4 at Clinic 3 on Thursday full day
    (3, 4, '18:00:00.000000', '09:00:00.000000', 'Thursday'),
    
    -- Dentist 1 at Clinic 2 on Friday afternoon
    (2, 1, '16:00:00.000000', '13:00:00.000000', 'Friday'),
    
    -- Dentist 2 at Clinic 3 on Saturday morning
    (3, 2, '12:00:00.000000', '08:00:00.000000', 'Saturday'),
    
    -- Dentist 3 at Clinic 2 on Monday evening (overlap test)
    (2, 3, '20:00:00.000000', '17:00:00.000000', 'Monday');

    
# API
    
## Patient

#### Create patient

```http
  POST /patient/register
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `first_name` | `string` | **Required**. |
| `last_name` | `string` | **Required**. |
| `email_address` | `string` | **Required**. |
| `gender` | `string` | **Required**. M/F|
| `dob` | `string` | **Required**. YYYY-mm-dd|
| `phone` | `string` | **Required**.|
| `password` | `string` | **Required**. hash|

#### Get patient by id 

```http
  GET /patient/id/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of item to fetch |


#### Get patients

```http
  GET /patient/list
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


```http
  POST /patient/login
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `email_address` | `string` | **Required**. |
| `password` | `string` | **Required**. hash|

## Item

#### Get items

```http
  GET /item/list
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


## Clinic

#### Get clinic by id 

```http
  GET /clinic/id/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of item to fetch |


#### Get clinics

```http
  GET /patient/list
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


## Dentist

#### Get dentist by id 

```http
  GET /dentist/id/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of item to fetch |


#### Get dentists

```http
  GET /dentist/list
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


## Clinic dentists

#### Get Clinic dentists by clinic_id 

```http
  GET /clinic_dentist/clinic_id/{clinic_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `clinic_id`      | `int` | **Required**. Id of item to fetch |

#### Get Clinic dentists by dentist_id 

```http
  GET /clinic_dentist/dentist_id/{dentist_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `dentist_id`      | `int` | **Required**. Id of item to fetch |

#### Get Clinic dentists by time_slot_id 

```http
  GET /clinic_dentist/time_slot_id/{time_slot_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `time_slot_id`      | `int` | **Required**. Id of item to fetch |


#### Get Clinic dentists

```http
  GET /clinic_dentist/list
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


## Dentist items

#### Get Dentist items by dentist_id 

```http
  GET /dentist_item/dentist_id/{dentist_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `dentist_id`      | `int` | **Required**. Id of item to fetch |

#### Get Dentist items by dentist_id 

```http
  GET /dentist_item/item_id/{item_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `item_id`      | `int` | **item_id**. Id of item to fetch |

#### Get Dentist items

```http
  GET /dentist_item/list
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


## Appointment

#### Create appointment

```http
  POST /appointment/create
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `patient_id` | `int` | **Required**. |
| `clinic_dentist_id` | `int` | **Required**. |
| `appointment_date` | `string` | **Required**. YYYY-mm-dd |
| `total_amount` | `decimal` | **Required**. 0.00|
| `status` | `string` | **Required**. |

#### Get patient by id 

```http
  GET /appointment/id/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of item to fetch |


#### Get patients

```http
  GET /appointment/list
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |

## Appointment items

#### Create appointment items

```http
  POST /appointment_item/create
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `appointment_id` | `int` | **Required**. |
| `dentist_item_id` | `int` | **Required**. |

#### Get patient by appointment_id 

```http
  GET /appointment_item/appointment_id/{appointment_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `appointment_id`      | `int` | **Required**. Id of item to fetch |

#### Get patient by dentist_item_id 

```http
  GET /appointment_item/dentist_item_id/{dentist_item_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `dentist_item_id`      | `int` | **Required**. Id of item to fetch |

