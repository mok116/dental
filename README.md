# springbootDemo

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
  GET /dentist_item/{item_id}
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
  GET /appointment/patient/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `patientId`      | `int` | **Required**. Id of item to fetch |


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
  GET /appointment_item/appointment/{appointment_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `appointment_id`      | `int` | **Required**. Id of item to fetch |

#### Get patient by dentist_item_id 

```http
  GET /appointment_item/dentistItem/{dentist_item_id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `dentist_item_id`      | `int` | **Required**. Id of item to fetch |

