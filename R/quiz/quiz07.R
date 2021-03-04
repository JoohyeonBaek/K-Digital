library(ggplot2)
library(dplyr)

mtcars

test1 <- data.frame(gear = c(1,2,3,4,5),
                    loc = c('울산공장','서울공장','부산공장','포항공장','경기공장'))

new_mtcars <- left_join(mtcars, test1, by='gear')
new_mtcars

test2 <- data.frame(gear=c(6,7),
                    loc=c("제주공장","거제도공장"))

new_gear <- bind_rows(test1, test2)
new_gear

emp <- read.csv("emp.csv")
dept <- read.csv("dept.csv")

test3 <- left_join(emp,dept, by='deptno')
test3

test3 %>% 
  group_by(deptno) %>% 
  summarise(mean_sal = mean(sal)) %>% 
  arrange(desc(mean_sal))

