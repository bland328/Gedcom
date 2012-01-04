/*
 * Copyright 2011 Foundation for On-Line Genealogy, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.folg.gedcom.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Simple data structure for a gedcom node - json-friendly
 * User: Dallan
 * Date: 12/23/11
 */
public class GedcomTag {
   public String id;
   public String tag;
   public String ref;
   public String value;
   public List<GedcomTag> children;
   
   public GedcomTag(String id, String tag, String ref) {
      this.id = id;
      this.tag = tag;
      this.ref = ref;
      this.value = null;
      this.children = null;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getTag() {
      return tag;
   }

   public void setTag(String tag) {
      this.tag = tag;
   }

   public String getRef() {
      return ref;
   }

   public void setRef(String ref) {
      this.ref = ref;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
   }

   public void appendValue(String value) {
      if (this.value == null) {
         this.value = value;
      }
      else {
         this.value += value;
      }
   }

   public List<GedcomTag> getChildren() {
      return children != null ? children : Collections.<GedcomTag>emptyList();
   }

   public void setChildren(List<GedcomTag> children) {
      this.children = children;
   }

   public void addChild(GedcomTag child) {
      if (children == null) {
         children = new ArrayList<GedcomTag>();
      }
      children.add(child);
   }

   @Override
   public boolean equals(Object o) {
      // TODO - compare hash codes for each child against all other children
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      GedcomTag gedcomTag = (GedcomTag) o;

      if (children != null ? !children.equals(gedcomTag.children) : gedcomTag.children != null) return false;
      if (id != null ? !id.equals(gedcomTag.id) : gedcomTag.id != null) return false;
      if (ref != null ? !ref.equals(gedcomTag.ref) : gedcomTag.ref != null) return false;
      if (tag != null ? !tag.equals(gedcomTag.tag) : gedcomTag.tag != null) return false;
      if (value != null ? !value.equals(gedcomTag.value) : gedcomTag.value != null) return false;

      return true;
   }

   @Override
   public int hashCode() {
      // TODO - sort hash codes for each child when computing hash code
      int result = id != null ? id.hashCode() : 0;
      result = 31 * result + (tag != null ? tag.hashCode() : 0);
      result = 31 * result + (ref != null ? ref.hashCode() : 0);
      result = 31 * result + (value != null ? value.hashCode() : 0);
      result = 31 * result + (children != null ? children.hashCode() : 0);
      return result;
   }
}
