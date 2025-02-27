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