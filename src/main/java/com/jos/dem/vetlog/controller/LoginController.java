/*
Copyright 2023 Jose Morales joseluis.delacruz@gmail.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.jos.dem.vetlog.controller;

import com.jos.dem.vetlog.service.LocaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

  private final LocaleService localeService;

  @GetMapping(value = "/login")
  public ModelAndView login(@RequestParam Optional<String> error, HttpServletRequest request) {
    log.info("Calling login");
    ModelAndView modelAndView = new ModelAndView("login/login");
    if (error.isPresent()) {
      log.info("Invalid credentials");
      modelAndView.addObject("message", localeService.getMessage("login.error", request));
    }
    return modelAndView;
  }

  @GetMapping(value = "/logout")
  public String logout() {
    return "redirect:/";
  }
}
