package io.github.emanuelmcp.kandorauth.rest;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import io.github.emanuelmcp.kandorauth.dto.UpdateGroupDto;
import io.github.emanuelmcp.kandorauth.entity.Group;

public interface GroupEndpoint {
    @RequestLine("GET /groups/{groupName}")
    Group getGroup(@Param("groupName") String groupName);

    @RequestLine("DELETE /groups/{groupName}")
    void delete(@Param("groupName") String groupName);
    @RequestLine("POST /groups/")
    @Headers("Content-Type: application/json")
    void save(Group group);
    @RequestLine("POST /groups/{groupName}")
    @Headers("Content-Type: application/json")
    void update(@Param("groupName") String groupName, UpdateGroupDto groupDto);
}
