# springbootDental

# API
    
## Patient

#### Create patient

```http
  POST /patient/register
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `firstName` | `string` | **Required**. |
| `lastName` | `string` | **Required**. |
| `emailAddress` | `string` | **Required**. |
| `gender` | `string` | **Required**. M/F|
| `dob` | `string` | **Required**. YYYY-mm-dd|
| `phone` | `string` | **Required**.|
| `password` | `string` | **Required**. hash|

#### Get patient by id 

```http
  GET /patient/{id}
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
| `emailAddress` | `string` | **Required**. |
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

```httpf
  GET /patient/list
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


## Dentist

#### Get dentist by id 

```http
  GET /dentist/{id}
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
  GET /clinicDentist/clinic/{clinicId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `clinicId`      | `int` | **Required**. Id of item to fetch |

#### Get Clinic dentists by dentist_id 

```http
  GET /clinicDentist/dentist/{dentistId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `dentistId`      | `int` | **Required**. Id of item to fetch |

#### Get Clinic dentists by time_slot_id 

```http
  GET /clinicDentist/timeslot/{timeslotId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `timeslotId`      | `int` | **Required**. Id of item to fetch |


#### Get Clinic dentists

```http
  GET /clinicDentist/list
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |


## Dentist items

#### Get Dentist items by dentist_id 

```http
  GET /dentistItem/dentist/{dentistId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `dentistId`      | `int` | **Required**. Id of item to fetch |

#### Get Dentist items by dentist_id 

```http
  GET /dentistItem/{itemId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `itemId`      | `int` | **item_id**. Id of item to fetch |

#### Get Dentist items

```http
  GET /dentistItem/list
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
| `patientId` | `int` | **Required**. |
| `clinicDentistId` | `int` | **Required**. |
| `appointmentDate` | `string` | **Required**. YYYY-mm-dd |
| `totalAmount` | `decimal` | **Required**. 0.00|
| `status` | `string` | **Required**. |

#### Get patient by id 

```http
  GET /appointment/patient/{patientId}
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
  POST /appointmentItem/create
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `appointmentId` | `int` | **Required**. |
| `dentistItemId` | `int` | **Required**. |

#### Get patient by appointment_id 

```http
  GET /appointmentItem/appointment/{appointmentId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `appointmentId`      | `int` | **Required**. Id of item to fetch |

#### Get patient by dentist_item_id 

```http
  GET /appointmentItem/dentistItem/{dentistItemId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `dentistItemId`      | `int` | **Required**. Id of item to fetch |

