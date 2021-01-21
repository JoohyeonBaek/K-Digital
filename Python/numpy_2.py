import numpy as np
import matplotlib.pyplot as pit
r = 1
t = np.linspace(-np.pi,np.pi,100)
x = r*np.sin(t)
y = r*np.cos(t)
pit.plot(x,y)
pit.axis('equal')