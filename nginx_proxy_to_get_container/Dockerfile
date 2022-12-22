FROM nginx

# Copy custom configuration file from the current directory
COPY nginx.conf /etc/nginx/nginx.conf

EXPOSE 80

# Run Nginx in the foreground
CMD ["nginx", "-g", "daemon off;"]
