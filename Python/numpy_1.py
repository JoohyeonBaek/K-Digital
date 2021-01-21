import numpy as np #선형대수 : ndarray배열 (list)
import matplotlib.pyplot as plot # 시각화

time = np.arange(0, 10, 0.1)
amplitude = np.sin(time)
plot.plot(time,amplitude) #보간법
plot.title('sign graph')
plot.xlabel('Time')
plot.ylabel('Amplitude=sin(time)')
plot.grid(True, which='both')
plot.axhline(y=0, color='k')
plot.show()