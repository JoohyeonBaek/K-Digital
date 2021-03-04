library(dplyr)

data <- data.frame(주문번호=c(1,1,2,3,4,4,4,5),
                       상품번호=c('A','B','C','A','K','D','A',5),
                       수량 = c(10,3,3,4,1,2,1,6))

dim(data)

save(data, file="C:/R_Study/R_basic/data.rda")
mean(data$수량)

data %>% 
  head(5)

data %>% 
  summarise()

data <- rename(data, ordid=주문번호)
data <- rename(data, proid=상품번호)
data <- rename(data, qty=수량)

data

write.csv(data, file="C:/R_Study/R_basic/data.csv")
