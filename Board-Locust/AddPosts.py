from locust import HttpUser, task, between
import random


class AddPosts(HttpUser):
    wait_time = between(0.05, 0.1)

    def on_start(self):
        self.client.post("/users/sign-in", json={"userId": "test",
                                                 "password": "test1"})

    @task
    def add_post(self):
        self.client.post("/posts", json={
            "name": "테스트 게시글" + str(random.randint(1, 100000)),
            "contents": "테스트 컨텐츠" + str(random.randint(1, 100000)),
            "categoryId": random.randint(1, 10),
            "fileId": random.randint(1, 10),
        })