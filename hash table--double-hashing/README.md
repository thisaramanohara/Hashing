Hash function ----> **h(k) = k % N**

Collisions are handled using double hashing with probe function,
<br>
**p(k,i) = i * (1 + k % (N-1))**
