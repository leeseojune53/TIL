FROM node:12    
WORKDIR /root
COPY . .
ENV NODE_ENV production
RUN npm install
COPY . .
RUN npm run build
CMD node dist/main.js